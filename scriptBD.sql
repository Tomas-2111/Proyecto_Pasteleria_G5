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
 (1,'ROLE_ADMIN'), (2,'CLIENTE');

create table pasteleriaG5.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  correo varchar(30) NOT NULL,
  contrasena VARCHAR(30) NOT NULL,
  id_rol INT,
  PRIMARY KEY (id_usuario),
  foreign key fk_rol_usuario (id_rol) references rol(id_rol))
ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO pasteleriaG5.usuario(id_usuario,nombre,correo,contrasena,id_rol) VALUES
(1,"TEST ADMIN","tojoalgu@gmail.com","pass123",1),(2,"TEST CLIENTE","cliente@gmail.com","cliente123",2);

SELECT * FROM pasteleriaG5.usuario;

CREATE TABLE pasteleriaG5.cotizaciones_pastel
(
	id INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR (500) NOT NULL,
    url_imagen VARCHAR (1024),
    id_usuario INT NOT NULL,
    PRIMARY KEY (id),
    foreign key fk_id_usuario (id_usuario) references usuario(id_usuario)
);
