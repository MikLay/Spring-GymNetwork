ALTER table equipment ADD image_url VARCHAR(255);
UPDATE equipment SET equipment.image_url = 'https://uz.all.biz/img/uz/catalog/52157.jpeg' WHERE (id = 1);
UPDATE equipment SET equipment.image_url = 'https://megaturnik.ua/content/images/6/395x413l80nn0/trenazher-ulichnyy-zhim-lezha-dlya-sportivnoy-ploshchadki-13283391038447.jpg' WHERE (id = 2);
