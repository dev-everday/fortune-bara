CREATE TABLE requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(255),
    endpoint VARCHAR(255),
    request_payload JSON,
    response_payload JSON,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);