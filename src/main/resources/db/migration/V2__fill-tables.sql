INSERT INTO user (id, username, password, roles)
VALUES (1, 'User1', 'pass1', 'ROLE_USER');

INSERT INTO user (id, username, password, roles)
VALUES (2, 'User2', 'pass2', 'ROLE_USER');

INSERT INTO item (id, sellable, item_name, description, photourl, starting_price, purchase_price,
                  last_offered_bid_id, user_id)
VALUES (1, 1, 'strandpapucs', 'Alig hasznalt, strandra kivalo', 'strandpapucs.jpg', 200, 2000, 1, 1);

INSERT INTO item (id, sellable, item_name, description, photourl, starting_price, purchase_price,
                  last_offered_bid_id, user_id)
VALUES (2, 1, 'csoki', 'Nem romlott, eheto', 'milka.jpg', 20, 40000, 2, 2);

INSERT INTO bid (id, amount, creation_date, item_id)
VALUES (1, 100, '2022-07-07 06:22:00.000000', 1);

INSERT INTO bid (id, amount, creation_date, item_id)
VALUES (2, 200, '2022-07-08 06:23:02.034308', 2);

INSERT INTO item_placed_bids (item_id, bid_id)
VALUES (1, 1);

INSERT INTO user_not_sold_items (user_id, item_id)
VALUES (1, 1);