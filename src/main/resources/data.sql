delete from Pizza_Order_Pizza;
delete from Pizza_Ingrdients;
delete from Pizza;
delete from Pizza_Order;

delete from Ingredient;

insert into Ingredient (id, name, type)
    values ('QQ','Kukurydza','WARZYWNE');

insert into Ingredient (id, name, type)
    values ('KU','Kurczak','MIESNE');

insert into Ingredient (id, name, type)
    values ('SZ','Szynka','MIESNE');

insert into Ingredient (id, name, type)
    values ('CZ','Czedar','SER');

insert into Ingredient (id, name, type)
    values ('PI','Pieczarki','INNE');
