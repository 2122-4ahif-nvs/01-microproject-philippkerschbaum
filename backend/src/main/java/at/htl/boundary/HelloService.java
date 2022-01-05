package at.htl.boundary;



import at.htl.Greeter;
import at.htl.HelloReply;
import at.htl.HelloRequest;
import at.htl.control.ClubRepository;
import at.htl.control.PlayerRepository;
import at.htl.entity.Team;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;

import javax.inject.Inject;

@GrpcService
public class HelloService implements Greeter {

    @Inject
    PlayerRepository playerRepository;

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item(() -> {
                    return playerRepository.getAllPlayersPerTeam(request.getName()).size();
                }).runSubscriptionOn(Infrastructure.getDefaultExecutor())
                .onItem().transform(i -> HelloReply.newBuilder().setMessage("PlayerCount of " + request.getName() +": "+Integer.toString(i)).build());
    }
}