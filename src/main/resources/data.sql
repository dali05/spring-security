CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL
);

CREATE TABLE authorities(
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL
);

CREATE TABLE users_authorities (
                                user_id INT,
                                authority_id INT,
                                PRIMARY KEY (user_id, authority_id),
                                FOREIGN KEY (user_id) REFERENCES users(id),
                                FOREIGN KEY (authority_id) REFERENCES authorities(id)
);
INSERT INTO users (id, username, password) VALUES (1, 'dali', 'dali');
INSERT INTO authorities (id, name) VALUES (1, 'read');
INSERT INTO users_authorities (user_id, authority_id) VALUES (1, 1);
-- Ajoutez autant d'insertions que nécessaire
