drop schema if exists pasteleriaG5; 
drop user if exists usuario_pasteleria; 
CREATE SCHEMA pasteleriaG5 ; 

create user 'usuario_pasteleria'@'%' identified by 'Pasteleria_G5'; 

grant all privileges on pasteleriaG5.* to 'usuario_pasteleria'@'%'; 
flush privileges;


create table pasteleriaG5.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  PRIMARY KEY (id_rol)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into pasteleriaG5.rol (id_rol, nombre) values
 (1,'ROLE_ADMIN'), (2,'ROLE_CLIENTE');

create table pasteleriaG5.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  correo varchar(30) NOT NULL,
  username VARCHAR (30) NOT NULL,
  telefono VARCHAR(30),
  password VARCHAR(250) NOT NULL,
  id_rol INT,
  PRIMARY KEY (id_usuario),
  foreign key fk_rol_usuario (id_rol) references rol(id_rol))
ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO pasteleriaG5.usuario(nombre,correo, username, password,id_rol) VALUES
("TEST ADMIN","tojoalgu@gmail.com","admin",'$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.',1),
("TEST CLIENTE","cliente@gmail.com","cliente",'$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi',2);

SELECT * FROM pasteleriaG5.usuario;

CREATE TABLE pasteleriaG5.cotizacion_pastel
(
	id INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR (500) NOT NULL,
    url_imagen VARCHAR (1024),
    id_usuario INT NOT NULL,
    estado VARCHAR (50) NOT NULL,
    PRIMARY KEY (id),
    foreign key fk_id_usuario (id_usuario) references usuario(id_usuario)
);

CREATE TABLE pasteleriaG5.cotizacion_reposteria
(
	id INT NOT NULL AUTO_INCREMENT,
    tipo_reposteria VARCHAR (20) NOT NULL,
    cantidad INT NOT NULL,
    descripcion VARCHAR (200),
    id_usuario INT NOT NULL,
    estado VARCHAR (50) NOT NULL,
    PRIMARY KEY (id),
    foreign key fk_id_usuario (id_usuario) references usuario(id_usuario)
);

INSERT INTO pasteleriag5.cotizacion_pastel(descripcion, id_usuario, estado) VALUES ("Tamaño: Pequeño - Sabor: Red Velvet - Relleno: Nutella - Cubierta: Semillas - Ingredientes Extra: ",2,"Pendiente Revision");
INSERT INTO pasteleriag5.cotizacion_pastel(descripcion, id_usuario, estado) VALUES ("Tamaño: Mediano - Sabor: Chocolate - Relleno: Nutella - Cubierta: Semillas - Ingredientes Extra: ",2,"En Revision");

INSERT INTO pasteleriag5.cotizacion_reposteria(tipo_reposteria, cantidad,id_usuario,estado) VALUES ("Salado",10,2,"En Revision");
INSERT INTO pasteleriag5.cotizacion_reposteria(tipo_reposteria, cantidad,id_usuario,estado) VALUES ("Mixto",10,2,"Finalizada");

SELECT * FROM pasteleriaG5.cotizacion_reposteria;
