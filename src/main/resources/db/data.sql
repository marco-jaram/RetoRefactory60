-- Sample Books
INSERT INTO books (name, description, price, stock, author, isbn, publisher, category, type) VALUES
('Ethics', 'A philosophical exploration of ethics', 29.99, 10, 'Aristotle', '9780872203914', 'Hackett', 'ETHICS', 'BOOK'),
('Logic Basics', 'Introduction to logic', 24.99, 15, 'John Doe', '9780123456789', 'Academia Press', 'LOGIC', 'BOOK');

-- Sample Board Games
INSERT INTO board_games (name, description, price, stock, min_players, max_players, recommended_age, playing_time_minutes, designer, category, type) VALUES
('Philosophy Quest', 'Educational philosophy game', 39.99, 5, 2, 6, 12, 60, 'Jane Smith', 'PHILOSOPHY_THEMED', 'BOARD_GAME'),
('Logic Master', 'Test your logical thinking', 34.99, 8, 1, 4, 10, 45, 'Mike Johnson', 'LOGIC', 'BOARD_GAME');

-- Sample EReaders
INSERT INTO ereaders (name, description, price, stock, brand, model, screen_size, storage_gb, has_backlight, type) VALUES
('PhiloReader Basic', 'Perfect for philosophy texts', 129.99, 20, 'PhiloTech', 'PR-100', 6.0, 8, true, 'EREADER'),
('PhiloReader Pro', 'Advanced reading experience', 199.99, 15, 'PhiloTech', 'PR-200', 7.0, 32, true, 'EREADER');