insert INTO sc_club(c_name) VALUES('club1');
insert INTO sc_club(c_name) VALUES('club2');
insert INTO sc_club(c_name) VALUES('club3');

insert into sc_team(t_name, t_club) values('U12',1);
insert into sc_team(t_name, t_club) values('U13',1);

insert into sc_team(t_name, t_club) values('U17',2);
insert into sc_team(t_name, t_club) values('U17',3);

insert into sc_player(p_firstname, p_lastname, p_team) values('Philipp','Kerschbaum',1);
insert into sc_player(p_firstname, p_lastname, p_team) values('Kurt','Bauer',2);
insert into sc_player(p_firstname, p_lastname, p_team) values('Max','Mustermann',3);