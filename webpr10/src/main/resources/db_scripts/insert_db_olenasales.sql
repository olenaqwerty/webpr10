USE olenasales;

INSERT INTO category (category_name, category_pic)
values('phones', 'http://s.developers.org.ua/storage-files/lat3.jpg'),
('tablets', 'http://s.developers.org.ua/storage-files/lat1.jpg'),
('ebooks', 'http://s.developers.org.ua/storage-files/lat2.jpg'),
('accessories', 'http://s.developers.org.ua/storage-files/lat3.jpg');

INSERT INTO product_colour(product_colour_name)
values('red'),
('green'),
('blue'),
('white'),
('black');

INSERT INTO vendor (vendor_name, vendor_address)
values('apple', 'Cupertino, USA, CA 95014'),
('samsung', 'Gyeonggi-do, Korea, 446-811'),
('nokia', 'Karaportti 3 FI-02610 Espoo'),
('htc', '13920 SE Eastgate Way, Suite 200 Bellevue, WA 98005');

INSERT INTO currency(currency_name, currency_sign)
values('dollars', '$'),
('hryvna', 'hrn');

INSERT INTO product (product_name, category_id, product_price, product_price_currency, product_description, product_colour_id, vendor_id, product_image, qty_in_stock)
values('htc one m9',1 ,39.99, 1, 'An award-winning tradition continues: 20 MP camera with sapphire camera cover lens to deliver crisp, clear photos. Front-facing stereo speakers with built-in amp and Dolby Audio™ surround for the ultimate audio experience.', 5, 4, 'http://s.developers.org.ua/storage-files/lat3.jpg', 0),
('HTC Dot View™ Ice',1 ,49.99, 1, 'Enhanced HTC Dot View™ Ice case provides all the features of the HTC Dot View™, with a transparent back cover. Show off your phone’s unique design and enjoy closed case interaction that won’t slow you down.', 5, 4, 'http://s.developers.org.ua/storage-files/lat3.jpg', 100),
('HTC Dot View™ Ice',1 ,49.99, 1,'Enhanced HTC Dot View™ Ice case provides all the features of the HTC Dot View™, with a transparent back cover. Show off your phone’s unique design and enjoy closed case interaction that won’t slow you down.', 4, 4, 'http://s.developers.org.ua/storage-files/lat3.jpg', 100),
('HTC Dot View™ Ice',1 ,59.99, 1,'Enhanced HTC Dot View™ Ice case provides all the features of the HTC Dot View™, with a transparent back cover. Show off your phone’s unique design and enjoy closed case interaction that won’t slow you down.', 3, 4, 'http://s.developers.org.ua/storage-files/lat3.jpg', 100),
('HTC Active Earphones',4, 26.99,1 , 'Waterproof, dust-proof, and sweat-proof headset comes with in-line microphone and 3 earbud sizes for the right fit.', 4, 4, 'http://s.developers.org.ua/storage-files/lat3.jpg', 50),
('HTC Rapid Charger 2.0', 4, 34.99,1 , 'Universal USB charger powers up your HTC smartphone in a blink.', 5 ,4 ,'http://s.developers.org.ua/storage-files/lat3.jpg', 50),
('iPhone 6',1 , 200.00, 1, 'isnt simply bigger — its better in every way. Larger, yet dramatically thinner', 5, 1,null, 20),
('iPhone 6',1 , 200.00, 1, 'isnt simply bigger — its better in every way. Larger, yet dramatically thinner', 4, 1,null, 20),
('iPad Air 2', 2 , 400.00, 1, 'Powerful, beautiful and simply brilliant - Apples taken the perfect tablet and made it even better.', 4, 1, null, 10),
('Apple EarPods with Remote and Mic', 4, 100.00, 1, 'Apple EarPods with Remote and Mic', 5, 1, null, 30),
('Galaxy Tab S 10.5 Wi-Fi',2 , 200.99, 1, 'Cinema ticket + £30 Google play voucher + 16GB memory card', 5, 2, null, 67),
('Galaxy Tab S 10.5 Wi-Fi (Dazzling White)', 2, 300.00, 1, 'free 16GB memory card & Cinema ticket +Google play voucher offer available', 4, 2, null, 100),
('Nokia Lumia 1520', 1, 200.00, 1, 'Meet the Lumia 1520, the phone with an extra-large, six-inch, 1080p full HD display with excellent outdoor readability.', 5, 3, null, 6),
('Nokia Lumia 2520', 2, 70.00, 1, 'Enjoy a 10.1" Full HD display with enhanced screen readability', 4, 3, null, 10);


INSERT INTO customers(customer_name, customer_surname, customer_phone, customer_address)
values('bill', 'jonson', '1234567', 'Lviv, Franko str 6'),
('jack', 'white', '1234567', 'Lviv, Franko str 5'),
('sam', 'black', '1234567', 'Lviv, Franko str 4'),
('ann', 'green', '1234567', 'Lviv, Franko str 3');

INSERT INTO orders(customer_id, order_date, order_sent_date, total_order_price)
VALUES
(1, '2014-11-11',null, 100.20),
(1, '2014-11-11', '2014-11-11', 200.99),
(1, '2015-01-01','2015-01-06', 340.00),
(2, '2015-01-03',null, 100.11),
(2, '2015-01-04',null, 500.00),
(3, '2015-01-06',null, 300.50),
(3, '2015-01-06','2015-01-06', 200.50),
(3, '2015-01-06', '2015-01-07', 400.70),
(3, '2015-01-06', '2015-01-06', 900.00);

INSERT INTO order_details(product_id, order_id, order_qty)
VALUES
(1, 1,1),
(1, 2,1),
(1, 3,1),
(6, 4,1),
(6, 5,1),
(6, 6,5),
(2, 7,5);

INSERT INTO payment_method(payment_method_name)
values('card'),
('cache');

INSERT INTO payment(order_id, payment_method_id, payment_status)
values(1, 1, true),
(2, 1, true),
(3, 1, true),
(4, 2, true),
(5, 2, false),
(6, 2, false),
(7, 1, false);
