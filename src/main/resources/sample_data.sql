ALTER TABLE image MODIFY COLUMN image_data LONGBLOB;

INSERT into category values (1,'breakfast');
INSERT into category values (2,'lunch');
INSERT into category values (3,'snacks');
INSERT into category values (4,'dinner');

INSERT INTO image values (1,null);
INSERT INTO image values (2,null);
INSERT INTO image values (3,null);
INSERT INTO image values (4,null);

INSERT INTO recipes values (1,'15 min','bread omlet',1,1);
INSERT INTO recipes values (2,'30 min','egg curry',1,2);
INSERT INTO recipes values (3,'10 min','bread toast',1,3);
INSERT INTO recipes values (4,'25 min','egg masala',1,4);

INSERT INTO recipe_categories values (1,'breakfast');
INSERT INTO recipe_categories values (2,'lunch');
INSERT INTO recipe_categories values (3,'snacks');
INSERT INTO recipe_categories values (4,'dinner');

