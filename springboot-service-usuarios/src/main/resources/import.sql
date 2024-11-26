INSERT INTO usuarios (username,password,nombre,apellido, email) Values (`gustavoo´,`12345´,1,`Gustavo´,`Rodrigues´,`gustavo@uanl.com´);
INSERT INTO usuarios (username,password,nombre,apellido, email) Values (`nissan´,`12345´,1,`Nissan´,`Gtr´,`nissan@uanl.com´);

INSTERT INTO roles (nombre) VALUES (`ROLE_USER´);
INSTERT INTO roles (nombre) VALUES (`ROLE_ADMIN´);

INSTERT INTO usuarios_to_roles (user_id,rooles_id) VALUES (1,1);
INSTERT INTO usuarios_to_roles (user_id,rooles_id) VALUES (2,2);
INSTERT INTO usuarios_to_roles (user_id,rooles_id) VALUES (2,1);