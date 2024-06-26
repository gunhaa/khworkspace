alter session set "_oracle_script" = true;

create user community_hgh identified by community1234;

alter user community_hgh default tablespace system quota unlimited on system;

grant connect, resource, create view to community_hgh;

