insert into campussen(naam, straat, huisNr, postCode, gemeente)
values ('test', 'test', 'test', 'test', 'test');
insert into campussentelefoonnrs(campusId, nummer, fax, opmerking)
values ((select id from campussen where naam = 'test'), '1', false, 'test');
