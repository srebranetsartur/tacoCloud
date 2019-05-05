create table if not exists ingredient (
  id varchar(4) primary key ,
  name varchar(25) not null ,
  type varchar(10) not null
);

create table if not exists taco (
  id identity primary key ,
  name varchar(50) not null,
  createdAt timestamp not null
);

create table if not exists taco_ingredients (
  taco bigint not null ,
  ingredient varchar(4) not null,
  foreign key (taco) references taco(id),
  foreign key (ingredient) references ingredient(id)
);


CREATE TABLE if not exists taco_order
(
  id identity primary key ,
  deliveryName varchar(50) not null,
  deliveryStreet varchar(50) not null,
  deliveryCity varchar(50) not null,
  deliveryState varchar(2) not null,
  deliveryZip varchar(10) not null ,
  ccNumber varchar(16) not null ,
  ccExpiration date not null ,
  ccCVV varchar(5) not null,
  createdAt timestamp not null
);

create table if not exists taco_order_tacos (
  tacoOrder bigint not null,
  taco bigint not null,
  foreign key (tacoOrder) references taco_order(id),
  foreign key (taco) references taco(id)
);

delete from taco_order_tacos;
delete from taco_ingredients;
delete from taco;
delete from taco_order;
delete from ingredient;

insert into ingredient (id, name, type) values ('FLTO', 'Flour Tortilla', 'WRAP'), ('COTO', 'Corn Tortilla', 'WRAP'), ('GRBF', 'Ground Beef', 'PROTEIN'), ('CARN', 'Carnitas', 'PROTEIN'), ('TMTO', 'Diced Tomatoes', 'VEGGIES'), ('LETC', 'Lettuce', 'VEGGIES'), ('CHED', 'Cheddar', 'CHEESE'),
  ('JACK', 'Monterrey Jack', 'CHEESE'), ('SLSA', 'Salsa', 'SAUCE'),
  ('SRCR', 'Sour Cream', 'SAUCE');

