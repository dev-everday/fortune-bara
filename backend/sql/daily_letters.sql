CREATE TABLE daily_letters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(255),
    date DATE,
    message TEXT,
    lucky_color VARCHAR(50),
    lucky_item VARCHAR(100),
    lucky_number INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);