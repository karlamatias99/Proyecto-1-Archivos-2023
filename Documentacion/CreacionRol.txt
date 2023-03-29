/*Creando el primer administrador, tendra acceso a todas las tablas*/
CREATE ROLE controlpersonal;

GRANT CONNECT ON DATABASE venta TO controlpersonal;

\c venta;

GRANT USAGE ON SCHEMA controlpersonal TO controlpersonal;
GRANT USAGE ON SCHEMA controlventas TO controlpersonal;
GRANT USAGE ON SCHEMA controltiendas TO controlpersonal;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA controlpersonal TO controlpersonal;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA controlventas TO controlpersonal;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA controltiendas TO controlpersonal;
GRANT USAGE, SELECT ON SEQUENCE controlventas.inventario_idinventario_seq TO controlpersonal;
GRANT USAGE, SELECT ON SEQUENCE controlventas.detalleventa_id_detalle_seq TO controlpersonal;
GRANT USAGE, SELECT ON SEQUENCE controlventas.venta_id_venta_seq TO controlpersonal;

CREATE USER admin1 WITH PASSWORD 'admin1234';

GRANT controlpersonal TO admin1;

psql -U admin1 ventaelec

