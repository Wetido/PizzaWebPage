/*create table if not exists Ingredient(
    id varchar(4) not null,
    name varchar(35) not null,
    type varchar(10) not null
);

create table if not exists Pizza(

    id identity,
    name varchar(50) not null,
    createAt timestamp not null
);

create table if not exists Pizza_Ingrdients(

    pizza bigint not null,
    ingredient varchar(4) not null
);

alter table Pizza_Ingrdients
    add foreign key(pizza) references Pizza(id);
alter table Pizza_Ingrdients
    add foreign key(ingredient) references Ingredient(id);


create table if not exists Pizza_order(

    id identity,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryZip varchar(6) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists Pizza_Order_Pizza(

    pizzaOrder bigint not null,
    pizza bigint not null
);

alter table Pizza_Order_Pizza
    add foreign key (pizzaOrder) references Pizza_Order(id);
alter table Pizza_Order_Pizza
    add foreign key (pizza) references Pizza(id);*/