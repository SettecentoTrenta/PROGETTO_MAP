CREATE TABLE IF NOT EXISTS inventory (
    id INT PRIMARY KEY,
<<<<<<< HEAD
    item_name VARCHAR(50),
    item_description VARCHAR(200)
=======
    item_name VARCHAR(35),
    item_description VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS ranking (
    id INT PRIMARY KEY,
    player_name VARCHAR(35),
    total_time TIME
>>>>>>> origin/master
);