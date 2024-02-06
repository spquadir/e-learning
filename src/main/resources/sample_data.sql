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

INSERT INTO recipe_nutritional_content values (1,'25 mg','Protein');
INSERT INTO recipe_nutritional_content values (1,'20 mg','Carbs');
INSERT INTO recipe_nutritional_content values (1,'15 mg','VitD');

INSERT INTO recipe_nutritional_content values (2,'250 mg','Protein');
INSERT INTO recipe_nutritional_content values (2,'200 mg','Carbs');
INSERT INTO recipe_nutritional_content values (2,'150 mg','VitD');

INSERT INTO recipe_nutritional_content values (3,'20 mg','Protein');
INSERT INTO recipe_nutritional_content values (3,'200 mg','Carbs');
INSERT INTO recipe_nutritional_content values (3,'12 mg','VitD');

INSERT INTO recipe_nutritional_content values (4,'15 mg','Protein');
INSERT INTO recipe_nutritional_content values (4,'10 mg','Carbs');
INSERT INTO recipe_nutritional_content values (4,'5 mg','VitD');

INSERT INTO recipe_ingredients values (1,'2 slices','Bread');
INSERT INTO recipe_ingredients values (1,'1 spoon','Salt');
INSERT INTO recipe_ingredients values (1,'1 glass','Oil');
INSERT INTO recipe_ingredients values (1,'2 pcs','Egg');

INSERT INTO recipe_ingredients values (2,'2 glass','Water');
INSERT INTO recipe_ingredients values (2,'1 spoon','Salt');
INSERT INTO recipe_ingredients values (2,'1 glass','Oil');
INSERT INTO recipe_ingredients values (2,'2 pcs','Egg');

INSERT INTO recipe_ingredients values (3,'2 slices','Bread');
INSERT INTO recipe_ingredients values (3,'1 spoon','Salt');
INSERT INTO recipe_ingredients values (3,'2 slice','Cheese');

INSERT INTO recipe_ingredients values (4,'2 dabba','Spices');
INSERT INTO recipe_ingredients values (4,'1 spoon','Salt');
INSERT INTO recipe_ingredients values (4,'1 glass','Oil');
INSERT INTO recipe_ingredients values (4,'2 pcs','Egg');

INSERT INTO recipe_directions values (1,'Take 2 slices of bread');
INSERT INTO recipe_directions values (1,'Take 2 murgi eggs');
INSERT INTO recipe_directions values (1,'Make omlet from murgi egg');
INSERT INTO recipe_directions values (1,'Wrap omlet over bread slices');

INSERT INTO recipe_directions values (2,'Take 2 eggs of murgi');
INSERT INTO recipe_directions values (2,'Boil 2 eggs and fry it with oil in pan');
INSERT INTO recipe_directions values (2,'Use salt & spices as per taste');
INSERT INTO recipe_directions values (2,'Mix everything in hot water and kha lo');

INSERT INTO recipe_directions values (3,'Take 2 slices of bread');
INSERT INTO recipe_directions values (3,'Use an electric toaster');
INSERT INTO recipe_directions values (3,'bs fir kya add some salt');
INSERT INTO recipe_directions values (3,'Mix everything and serve hot');

INSERT INTO recipe_directions values (4,'Take 2 eggs of murgi');
INSERT INTO recipe_directions values (4,'Boil 2 eggs and fry it with oil in pan');
INSERT INTO recipe_directions values (4,'Use salt & spices as per taste');
INSERT INTO recipe_directions values (4,'Fry with spices in pan for 10 min and thoos lo');



