-- :name insert-user :i!
insert into users (created, mail)
values (:created, :mail)

-- :name get-user-by-mail :? :1
select * from users where mail = :mail
