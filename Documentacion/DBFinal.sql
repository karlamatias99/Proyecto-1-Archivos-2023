CREATE DATABASE venta;

\c venta;

CREATE SCHEMA controlpersonal;
CREATE SCHEMA controlventas;
CREATE SCHEMA controltiendas;

CREATE TABLE controlventas.cliente(
	nit  VARCHAR(10),
	nombre VARCHAR(50) NOT NULL,
	direccion VARCHAR(50) NOT NULL,
	PRIMARY KEY(nit)
);

CREATE TABLE controltiendas.sucursal(
	codigo_tienda VARCHAR(8) NOT NULL,
	nombreTienda VARCHAR(50),
	PRIMARY KEY(codigo_tienda)
);

CREATE TABLE controlpersonal.rol(
	idrol SERIAL,
	nombrerol VARCHAR(20),
	PRIMARY KEY(idrol)
);

CREATE TABLE controlpersonal.empleado(
	codigo_empleado VARCHAR(8) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	password VARCHAR(10) NOT NULL,
	rol SERIAL,
    sucursal VARCHAR(8),
	PRIMARY KEY(codigo_empleado),
	FOREIGN KEY(rol) REFERENCES controlpersonal.rol(idrol),
    FOREIGN KEY(sucursal) REFERENCES controltiendas.sucursal(codigo_tienda)
);

CREATE TABLE controlventas.producto(
	codigo_producto VARCHAR(8),
	nombreProducto VARCHAR(50),
	descripcion VARCHAR(50),
    precio_unidad DECIMAL(10,2),
	PRIMARY KEY(codigo_producto)
);

CREATE TABLE controlventas.inventario(
	idInventario SERIAL,
	sucursal VARCHAR(8),
	producto VARCHAR(8),
    stock INT,
	PRIMARY KEY (idInventario),
    FOREIGN KEY(sucursal) REFERENCES controltiendas.sucursal(codigo_tienda),
	FOREIGN KEY(producto) REFERENCES controlventas.producto(codigo_producto)
);

CREATE TABLE controlventas.venta(
	num_venta SERIAL,
	sucursal VARCHAR(8),
	vendedor VARCHAR(8),
	cliente VARCHAR(10),
	producto VARCHAR(8),
	monto_venta DECIMAL(10,2),
 	PRIMARY KEY(num_venta),
	FOREIGN KEY(sucursal) REFERENCES controltiendas.sucursal(codigo_tienda),
	FOREIGN KEY(vendedor) REFERENCES controlpersonal.empleado(codigo_empleado),
	FOREIGN KEY(cliente) REFERENCES  controlventas.cliente(nit),
	FOREIGN KEY(producto) REFERENCES  controlventas.producto(codigo_producto)
);

CREATE TABLE controlventas.detalleventa(
	id_detalle SERIAL,
    idventa INT,
    idprod VARCHAR(8),
    cantidad INT,
    precio DECIMAL(10,2),
    descuento DECIMAL(10,2),
    PRIMARY KEY (id_detalle),
    FOREIGN KEY(idventa) REFERENCES controlventas.venta(num_venta),
    FOREIGN KEY(idprod) REFERENCES controlventas.producto(codigo_producto)
);