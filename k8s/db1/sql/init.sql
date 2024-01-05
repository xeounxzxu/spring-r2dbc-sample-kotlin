-- default table add

create SCHEMA WEBFLUX;

create table WEBFLUX.mileage
(
    id         bigint NOT NULL AUTO_INCREMENT,
    user_id    bigint NOT NULL unique,
    point      bigint not null,
    created_at timestamp null,
    updated_at timestamp null,
    CONSTRAINT mileage_pk PRIMARY KEY (id)
);

create table WEBFLUX.mileage_history_2
(
    id         bigint NOT NULL AUTO_INCREMENT,
    ref_id     bigint not null,
    user_id    bigint NOT NULL unique,
    point      bigint not null,
    created_at timestamp null,
    updated_at timestamp null,
    updated_yn tinyint(1),
    CONSTRAINT mileage_2_pk PRIMARY KEY (id)
);


CREATE TABLE WEBFLUX.item
(
    id          INT          NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    type        VARBINARY(255) null,
    count       bigint null,
    limit_count bigint null,
    created_at  BIGINT(19) null,
    CONSTRAINT item_pk PRIMARY KEY (id)
);

-- item_history
create table WEBFLUX.item_history
(
    id          bigint       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    type        VARBINARY(255) null,
    count       bigint null,
    limit_count bigint null,
    item_id     INT          not null,
    -- bigint(19)
    created_at  bigint null,
    CONSTRAINT item_history_pk PRIMARY KEY (id),
    constraint item_history_item_null_fk
        foreign key (item_id) references item (id)
);

insert into WEBFLUX.item (id, name)
values (1, 'Collared lizard');
insert into WEBFLUX.item (id, name)
values (2, 'Sloth, two-toed tree');
insert into WEBFLUX.item (id, name)
values (3, 'North American red fox');
insert into WEBFLUX.item (id, name)
values (4, 'White-throated robin');
insert into WEBFLUX.item (id, name)
values (5, 'Red-knobbed coot');
insert into WEBFLUX.item (id, name)
values (6, 'Black and white colobus');
insert into WEBFLUX.item (id, name)
values (7, 'Fox, north american red');
insert into WEBFLUX.item (id, name)
values (8, 'Guerza');
insert into WEBFLUX.item (id, name)
values (9, 'Grey phalarope');
insert into WEBFLUX.item (id, name)
values (10, 'Green-backed heron');
insert into WEBFLUX.item (id, name)
values (11, 'Devil, tasmanian');
insert into WEBFLUX.item (id, name)
values (12, 'Stork, openbill');
insert into WEBFLUX.item (id, name)
values (13, 'Snake, eastern indigo');
insert into WEBFLUX.item (id, name)
values (14, 'Trumpeter, dark-winged');
insert into WEBFLUX.item (id, name)
values (15, 'Pigeon, feral rock');
insert into WEBFLUX.item (id, name)
values (16, 'Legaan, Monitor (unidentified)');
insert into WEBFLUX.item (id, name)
values (17, 'Deer, savannah');
insert into WEBFLUX.item (id, name)
values (18, 'Snake, green vine');
insert into WEBFLUX.item (id, name)
values (19, 'Pronghorn');
insert into WEBFLUX.item (id, name)
values (20, 'Crane, sandhill');
insert into WEBFLUX.item (id, name)
values (21, 'Dabchick');
insert into WEBFLUX.item (id, name)
values (22, 'Tern, arctic');
insert into WEBFLUX.item (id, name)
values (23, 'Bush dog');
insert into WEBFLUX.item (id, name)
values (24, 'Pied crow');
insert into WEBFLUX.item (id, name)
values (25, 'Sungazer, yellow-brown');
insert into WEBFLUX.item (id, name)
values (26, 'Dog, black-tailed prairie');
insert into WEBFLUX.item (id, name)
values (27, 'Harbor seal');
insert into WEBFLUX.item (id, name)
values (28, 'Tortoise, asian foreset');
insert into WEBFLUX.item (id, name)
values (29, 'Roan antelope');
insert into WEBFLUX.item (id, name)
values (30, 'European wild cat');
insert into WEBFLUX.item (id, name)
values (31, 'Sambar');
insert into WEBFLUX.item (id, name)
values (32, 'Pigeon, feral rock');
insert into WEBFLUX.item (id, name)
values (33, 'Arctic fox');
insert into WEBFLUX.item (id, name)
values (34, 'Jabiru stork');
insert into WEBFLUX.item (id, name)
values (35, 'Common ringtail');
insert into WEBFLUX.item (id, name)
values (36, 'Wolf, mexican');
insert into WEBFLUX.item (id, name)
values (37, 'Common mynah');
insert into WEBFLUX.item (id, name)
values (38, 'Greater kudu');
insert into WEBFLUX.item (id, name)
values (39, 'Quail, gambel''s');
insert into WEBFLUX.item (id, name)
values (40, 'American racer');
insert into WEBFLUX.item (id, name)
values (41, 'Western grey kangaroo');
insert into WEBFLUX.item (id, name)
values (42, 'Gray langur');
insert into WEBFLUX.item (id, name)
values (43, 'Eleven-banded armadillo (unidentified)');
insert into WEBFLUX.item (id, name)
values (44, 'Darter, african');
insert into WEBFLUX.item (id, name)
values (45, 'Yellow-billed stork');
insert into WEBFLUX.item (id, name)
values (46, 'Marabou stork');
insert into WEBFLUX.item (id, name)
values (47, 'Penguin, galapagos');
insert into WEBFLUX.item (id, name)
values (48, 'Guerza');
insert into WEBFLUX.item (id, name)
values (49, 'Cormorant, large');
insert into WEBFLUX.item (id, name)
values (50, 'Wagtail, african pied');
insert into WEBFLUX.item (id, name)
values (51, 'Cockatoo, red-breasted');
insert into WEBFLUX.item (id, name)
values (52, 'Pintail, bahama');
insert into WEBFLUX.item (id, name)
values (53, 'Bird, pied butcher');
insert into WEBFLUX.item (id, name)
values (54, 'Great horned owl');
insert into WEBFLUX.item (id, name)
values (55, 'Racer, american');
insert into WEBFLUX.item (id, name)
values (56, 'Lesser flamingo');
insert into WEBFLUX.item (id, name)
values (57, 'Squirrel, grey-footed');
insert into WEBFLUX.item (id, name)
values (58, 'Blue duck');
insert into WEBFLUX.item (id, name)
values (59, 'Southern hairy-nosed wombat');
insert into WEBFLUX.item (id, name)
values (60, 'Lion, galapagos sea');
insert into WEBFLUX.item (id, name)
values (61, 'Dolphin, common');
insert into WEBFLUX.item (id, name)
values (62, 'African clawless otter');
insert into WEBFLUX.item (id, name)
values (63, 'Eastern grey kangaroo');
insert into WEBFLUX.item (id, name)
values (64, 'Glossy ibis');
insert into WEBFLUX.item (id, name)
values (65, 'Deer, barasingha');
insert into WEBFLUX.item (id, name)
values (66, 'Asian false vampire bat');
insert into WEBFLUX.item (id, name)
values (67, 'Common brushtail possum');
insert into WEBFLUX.item (id, name)
values (68, 'African buffalo');
insert into WEBFLUX.item (id, name)
values (69, 'Hornbill, red-billed');
insert into WEBFLUX.item (id, name)
values (70, 'Yellow-necked spurfowl');
insert into WEBFLUX.item (id, name)
values (71, 'African clawless otter');
insert into WEBFLUX.item (id, name)
values (72, 'Elk, Wapiti');
insert into WEBFLUX.item (id, name)
values (73, 'Brazilian otter');
insert into WEBFLUX.item (id, name)
values (74, 'Ornate rock dragon');
insert into WEBFLUX.item (id, name)
values (75, 'Owl, great horned');
insert into WEBFLUX.item (id, name)
values (76, 'Great horned owl');
insert into WEBFLUX.item (id, name)
values (77, 'American Virginia opossum');
insert into WEBFLUX.item (id, name)
values (78, 'Cat, kaffir');
insert into WEBFLUX.item (id, name)
values (79, 'Deer, swamp');
insert into WEBFLUX.item (id, name)
values (80, 'Lesser mouse lemur');
insert into WEBFLUX.item (id, name)
values (81, 'Nighthawk, common');
insert into WEBFLUX.item (id, name)
values (82, 'Squirrel, european red');
insert into WEBFLUX.item (id, name)
values (83, 'Emu');
insert into WEBFLUX.item (id, name)
values (84, 'Asian lion');
insert into WEBFLUX.item (id, name)
values (85, 'Eland, common');
insert into WEBFLUX.item (id, name)
values (86, 'Cormorant, large');
insert into WEBFLUX.item (id, name)
values (87, 'Red-shouldered glossy starling');
insert into WEBFLUX.item (id, name)
values (88, 'Meerkat, red');
insert into WEBFLUX.item (id, name)
values (89, 'Gnu, brindled');
insert into WEBFLUX.item (id, name)
values (90, 'Tern, arctic');
insert into WEBFLUX.item (id, name)
values (91, 'Canada goose');
insert into WEBFLUX.item (id, name)
values (92, 'Superb starling');
insert into WEBFLUX.item (id, name)
values (93, 'Steenbok');
insert into WEBFLUX.item (id, name)
values (94, 'Anteater, australian spiny');
insert into WEBFLUX.item (id, name)
values (95, 'Blue and yellow macaw');
insert into WEBFLUX.item (id, name)
values (96, 'Zorro, common');
insert into WEBFLUX.item (id, name)
values (97, 'Brazilian otter');
insert into WEBFLUX.item (id, name)
values (98, 'Australian brush turkey');
insert into WEBFLUX.item (id, name)
values (99, 'Dark-winged trumpeter');
insert into WEBFLUX.item (id, name)
values (100, 'Red-winged blackbird');
insert into WEBFLUX.item (id, name)
values (101, 'Leadbeateri''s ground hornbill');
insert into WEBFLUX.item (id, name)
values (102, 'Mountain lion');
insert into WEBFLUX.item (id, name)
values (103, 'Hare, arctic');
insert into WEBFLUX.item (id, name)
values (104, 'Madagascar fruit bat');
insert into WEBFLUX.item (id, name)
values (105, 'Sociable weaver');
insert into WEBFLUX.item (id, name)
values (106, 'Skunk, western spotted');
insert into WEBFLUX.item (id, name)
values (107, 'Black-faced kangaroo');
insert into WEBFLUX.item (id, name)
values (108, 'Moccasin, water');
insert into WEBFLUX.item (id, name)
values (109, 'Echidna, short-beaked');
insert into WEBFLUX.item (id, name)
values (110, 'Ringtail cat');
insert into WEBFLUX.item (id, name)
values (111, 'Pale white-eye');
insert into WEBFLUX.item (id, name)
values (112, 'Land iguana');
insert into WEBFLUX.item (id, name)
values (113, 'Pelican, great white');
insert into WEBFLUX.item (id, name)
values (114, 'Cat, kaffir');
insert into WEBFLUX.item (id, name)
values (115, 'Ferruginous hawk');
insert into WEBFLUX.item (id, name)
values (116, 'Potoroo');
insert into WEBFLUX.item (id, name)
values (117, 'Dusky gull');
insert into WEBFLUX.item (id, name)
values (118, 'Long-crested hawk eagle');
insert into WEBFLUX.item (id, name)
values (119, 'Buttermilk snake');
insert into WEBFLUX.item (id, name)
values (120, 'Crane, stanley');
insert into WEBFLUX.item (id, name)
values (121, 'Carmine bee-eater');
insert into WEBFLUX.item (id, name)
values (122, 'Langur, gray');
insert into WEBFLUX.item (id, name)
values (123, 'Tyrant flycatcher');
insert into WEBFLUX.item (id, name)
values (124, 'White-throated kingfisher');
insert into WEBFLUX.item (id, name)
values (125, 'Gull, lava');
insert into WEBFLUX.item (id, name)
values (126, 'White-browed owl');
insert into WEBFLUX.item (id, name)
values (127, 'Ass, asiatic wild');
insert into WEBFLUX.item (id, name)
values (128, 'Bandicoot, southern brown');
insert into WEBFLUX.item (id, name)
values (129, 'African darter');
insert into WEBFLUX.item (id, name)
values (130, 'Vulture, black');
insert into WEBFLUX.item (id, name)
values (131, 'Sloth, hoffman''s');
insert into WEBFLUX.item (id, name)
values (132, 'Gecko (unidentified)');
insert into WEBFLUX.item (id, name)
values (133, 'Coke''s hartebeest');
insert into WEBFLUX.item (id, name)
values (134, 'Savannah deer');
insert into WEBFLUX.item (id, name)
values (135, 'Glider, sugar');
insert into WEBFLUX.item (id, name)
values (136, 'Downy woodpecker');
insert into WEBFLUX.item (id, name)
values (137, 'Green vine snake');
insert into WEBFLUX.item (id, name)
values (138, 'Grenadier, common');
insert into WEBFLUX.item (id, name)
values (139, 'Finch, common melba');
insert into WEBFLUX.item (id, name)
values (140, 'American badger');
insert into WEBFLUX.item (id, name)
values (141, 'Red-knobbed coot');
insert into WEBFLUX.item (id, name)
values (142, 'Glider, sugar');
insert into WEBFLUX.item (id, name)
values (143, 'Deer, white-tailed');
insert into WEBFLUX.item (id, name)
values (144, 'Cape Barren goose');
insert into WEBFLUX.item (id, name)
values (145, 'Tarantula, salmon pink bird eater');
insert into WEBFLUX.item (id, name)
values (146, 'Red-tailed hawk');
insert into WEBFLUX.item (id, name)
values (147, 'Fox, cape');
insert into WEBFLUX.item (id, name)
values (148, 'Japanese macaque');
insert into WEBFLUX.item (id, name)
values (149, 'Lilac-breasted roller');
insert into WEBFLUX.item (id, name)
values (150, 'Crane, sandhill');
insert into WEBFLUX.item (id, name)
values (151, 'Darter, african');
insert into WEBFLUX.item (id, name)
values (152, 'Deer, barasingha');
insert into WEBFLUX.item (id, name)
values (153, 'North American beaver');
insert into WEBFLUX.item (id, name)
values (154, 'Puma, south american');
insert into WEBFLUX.item (id, name)
values (155, 'Eagle, bateleur');
insert into WEBFLUX.item (id, name)
values (156, 'Hawk-headed parrot');
insert into WEBFLUX.item (id, name)
values (157, 'Dragon, netted rock');
insert into WEBFLUX.item (id, name)
values (158, 'Cape raven');
insert into WEBFLUX.item (id, name)
values (159, 'Northern fur seal');
insert into WEBFLUX.item (id, name)
values (160, 'Wallaby, river');
insert into WEBFLUX.item (id, name)
values (161, 'Carmine bee-eater');
insert into WEBFLUX.item (id, name)
values (162, 'Mandras tree shrew');
insert into WEBFLUX.item (id, name)
values (163, 'Owl, madagascar hawk');
insert into WEBFLUX.item (id, name)
values (164, 'Plover, three-banded');
insert into WEBFLUX.item (id, name)
values (165, 'Horned rattlesnake');
insert into WEBFLUX.item (id, name)
values (166, 'Vervet monkey');
insert into WEBFLUX.item (id, name)
values (167, 'Great egret');
insert into WEBFLUX.item (id, name)
values (168, 'Tropical buckeye butterfly');
insert into WEBFLUX.item (id, name)
values (169, 'Marine iguana');
insert into WEBFLUX.item (id, name)
values (170, 'Red meerkat');
insert into WEBFLUX.item (id, name)
values (171, 'Jackal, silver-backed');
insert into WEBFLUX.item (id, name)
values (172, 'Palm squirrel');
insert into WEBFLUX.item (id, name)
values (173, 'Goose, cape barren');
insert into WEBFLUX.item (id, name)
values (174, 'Cat, ringtail');
insert into WEBFLUX.item (id, name)
values (175, 'Ocelot');
insert into WEBFLUX.item (id, name)
values (176, 'Flycatcher, tyrant');
insert into WEBFLUX.item (id, name)
values (177, 'Mocking cliffchat');
insert into WEBFLUX.item (id, name)
values (178, 'Dromedary camel');
insert into WEBFLUX.item (id, name)
values (179, 'Oribi');
insert into WEBFLUX.item (id, name)
values (180, 'Quail, gambel''s');
insert into WEBFLUX.item (id, name)
values (181, 'Mudskipper (unidentified)');
insert into WEBFLUX.item (id, name)
values (182, 'Olive baboon');
insert into WEBFLUX.item (id, name)
values (183, 'Slender-billed cockatoo');
insert into WEBFLUX.item (id, name)
values (184, 'Eagle, white-bellied sea');
insert into WEBFLUX.item (id, name)
values (185, 'Sambar');
insert into WEBFLUX.item (id, name)
values (186, 'Cat, long-tailed spotted');
insert into WEBFLUX.item (id, name)
values (187, 'Vervet monkey');
insert into WEBFLUX.item (id, name)
values (188, 'Clark''s nutcracker');
insert into WEBFLUX.item (id, name)
values (189, 'Antechinus, brown');
insert into WEBFLUX.item (id, name)
values (190, 'Masked booby');
insert into WEBFLUX.item (id, name)
values (191, 'Richardson''s ground squirrel');
insert into WEBFLUX.item (id, name)
values (192, 'Baboon, olive');
insert into WEBFLUX.item (id, name)
values (193, 'Little blue penguin');
insert into WEBFLUX.item (id, name)
values (194, 'Lynx, african');
insert into WEBFLUX.item (id, name)
values (195, 'Bobcat');
insert into WEBFLUX.item (id, name)
values (196, 'Brush-tailed phascogale');
insert into WEBFLUX.item (id, name)
values (197, 'Cape starling');
insert into WEBFLUX.item (id, name)
values (198, 'Openbill, asian');
insert into WEBFLUX.item (id, name)
values (199, 'European red squirrel');
insert into WEBFLUX.item (id, name)
values (200, 'Silver-backed fox');
insert into WEBFLUX.item (id, name)
values (201, 'European shelduck');
insert into WEBFLUX.item (id, name)
values (202, 'Otter, cape clawless');
insert into WEBFLUX.item (id, name)
values (203, 'Flying fox (unidentified)');
insert into WEBFLUX.item (id, name)
values (204, 'Weaver, white-browed sparrow');
insert into WEBFLUX.item (id, name)
values (205, 'Stork, yellow-billed');
insert into WEBFLUX.item (id, name)
values (206, 'Cape white-eye');
insert into WEBFLUX.item (id, name)
values (207, 'Gray rhea');
insert into WEBFLUX.item (id, name)
values (208, 'Lesser masked weaver');
insert into WEBFLUX.item (id, name)
values (209, 'Dusky rattlesnake');
insert into WEBFLUX.item (id, name)
values (210, 'Cormorant, neotropic');
insert into WEBFLUX.item (id, name)
values (211, 'Lion, mountain');
insert into WEBFLUX.item (id, name)
values (212, 'Barbet, levaillant''s');
insert into WEBFLUX.item (id, name)
values (213, 'Porcupine, north american');
insert into WEBFLUX.item (id, name)
values (214, 'Egret, snowy');
insert into WEBFLUX.item (id, name)
values (215, 'Waxbill, black-cheeked');
insert into WEBFLUX.item (id, name)
values (216, 'Hawk, galapagos');
insert into WEBFLUX.item (id, name)
values (217, 'Dog, raccoon');
insert into WEBFLUX.item (id, name)
values (218, 'Grey phalarope');
insert into WEBFLUX.item (id, name)
values (219, 'White stork');
insert into WEBFLUX.item (id, name)
values (220, 'Cat, native');
insert into WEBFLUX.item (id, name)
values (221, 'Cormorant, large');
insert into WEBFLUX.item (id, name)
values (222, 'Caiman, spectacled');
insert into WEBFLUX.item (id, name)
values (223, 'American bighorn sheep');
insert into WEBFLUX.item (id, name)
values (224, 'Anteater, australian spiny');
insert into WEBFLUX.item (id, name)
values (225, 'Crane, stanley');
insert into WEBFLUX.item (id, name)
values (226, 'Pintail, bahama');
insert into WEBFLUX.item (id, name)
values (227, 'Monkey, vervet');
insert into WEBFLUX.item (id, name)
values (228, 'Chuckwalla');
insert into WEBFLUX.item (id, name)
values (229, 'African fish eagle');
insert into WEBFLUX.item (id, name)
values (230, 'Butterfly (unidentified)');
insert into WEBFLUX.item (id, name)
values (231, 'Grant''s gazelle');
insert into WEBFLUX.item (id, name)
values (232, 'Short-nosed bandicoot');
insert into WEBFLUX.item (id, name)
values (233, 'Buffalo, asian water');
insert into WEBFLUX.item (id, name)
values (234, 'Hawk-headed parrot');
insert into WEBFLUX.item (id, name)
values (235, 'Long-billed cockatoo');
insert into WEBFLUX.item (id, name)
values (236, 'Guerza');
insert into WEBFLUX.item (id, name)
values (237, 'Burmese black mountain tortoise');
insert into WEBFLUX.item (id, name)
values (238, 'Red-capped cardinal');
insert into WEBFLUX.item (id, name)
values (239, 'Cuis');
insert into WEBFLUX.item (id, name)
values (240, 'Grey lourie');
insert into WEBFLUX.item (id, name)
values (241, 'Rufous tree pie');
insert into WEBFLUX.item (id, name)
values (242, 'Helmeted guinea fowl');
insert into WEBFLUX.item (id, name)
values (243, 'Jackal, asiatic');
insert into WEBFLUX.item (id, name)
values (244, 'Vulture, lappet-faced');
insert into WEBFLUX.item (id, name)
values (245, 'Black-tailed deer');
insert into WEBFLUX.item (id, name)
values (246, 'Turtle, long-necked');
insert into WEBFLUX.item (id, name)
values (247, 'Jaeger, long-tailed');
insert into WEBFLUX.item (id, name)
values (248, 'Wallaby, euro');
insert into WEBFLUX.item (id, name)
values (249, 'Black-necked stork');
insert into WEBFLUX.item (id, name)
values (250, 'Common raccoon');
insert into WEBFLUX.item (id, name)
values (251, 'Robin, white-throated');
insert into WEBFLUX.item (id, name)
values (252, 'Owl, snowy');
insert into WEBFLUX.item (id, name)
values (253, 'Honey badger');
insert into WEBFLUX.item (id, name)
values (254, 'Barbet, black-collared');
insert into WEBFLUX.item (id, name)
values (255, 'Oryx, fringe-eared');
insert into WEBFLUX.item (id, name)
values (256, 'Turkey vulture');
insert into WEBFLUX.item (id, name)
values (257, 'Sun gazer');
insert into WEBFLUX.item (id, name)
values (258, 'Glossy ibis');
insert into WEBFLUX.item (id, name)
values (259, 'Black swan');
insert into WEBFLUX.item (id, name)
values (260, 'Turtle, snake-necked');
insert into WEBFLUX.item (id, name)
values (261, 'Common shelduck');
insert into WEBFLUX.item (id, name)
values (262, 'Bison, american');
insert into WEBFLUX.item (id, name)
values (263, 'Phalarope, northern');
insert into WEBFLUX.item (id, name)
values (264, 'Starling, cape');
insert into WEBFLUX.item (id, name)
values (265, 'Hoffman''s sloth');
insert into WEBFLUX.item (id, name)
values (266, 'White-fronted capuchin');
insert into WEBFLUX.item (id, name)
values (267, 'Wattled crane');
insert into WEBFLUX.item (id, name)
values (268, 'Horned puffin');
insert into WEBFLUX.item (id, name)
values (269, 'Pine snake (unidentified)');
insert into WEBFLUX.item (id, name)
values (270, 'Viper, egyptian');
insert into WEBFLUX.item (id, name)
values (271, 'Australian pelican');
insert into WEBFLUX.item (id, name)
values (272, 'Macaw, blue and yellow');
insert into WEBFLUX.item (id, name)
values (273, 'Iguana, land');
insert into WEBFLUX.item (id, name)
values (274, 'Kangaroo, brush-tailed rat');
insert into WEBFLUX.item (id, name)
values (275, 'Red-shouldered glossy starling');
insert into WEBFLUX.item (id, name)
values (276, 'Brown and yellow marshbird');
insert into WEBFLUX.item (id, name)
values (277, 'Yellow-billed hornbill');
insert into WEBFLUX.item (id, name)
values (278, 'Great white pelican');
insert into WEBFLUX.item (id, name)
values (279, 'Common raccoon');
insert into WEBFLUX.item (id, name)
values (280, 'Prairie falcon');
insert into WEBFLUX.item (id, name)
values (281, 'Crake, african black');
insert into WEBFLUX.item (id, name)
values (282, 'Stanley bustard');
insert into WEBFLUX.item (id, name)
values (283, 'Red-breasted nuthatch');
insert into WEBFLUX.item (id, name)
values (284, 'Common genet');
insert into WEBFLUX.item (id, name)
values (285, 'Dromedary camel');
insert into WEBFLUX.item (id, name)
values (286, 'Crane, black-crowned');
insert into WEBFLUX.item (id, name)
values (287, 'Tiger snake');
insert into WEBFLUX.item (id, name)
values (288, 'Plains zebra');
insert into WEBFLUX.item (id, name)
values (289, 'Bonnet macaque');
insert into WEBFLUX.item (id, name)
values (290, 'Sage hen');
insert into WEBFLUX.item (id, name)
values (291, 'Indian porcupine');
insert into WEBFLUX.item (id, name)
values (292, 'Cattle egret');
insert into WEBFLUX.item (id, name)
values (293, 'Heron, goliath');
insert into WEBFLUX.item (id, name)
values (294, 'Neotropic cormorant');
insert into WEBFLUX.item (id, name)
values (295, 'Grouse, greater sage');
insert into WEBFLUX.item (id, name)
values (296, 'Moccasin, water');
insert into WEBFLUX.item (id, name)
values (297, 'Snowy sheathbill');
insert into WEBFLUX.item (id, name)
values (298, 'Gecko, bent-toed');
insert into WEBFLUX.item (id, name)
values (299, 'Red brocket');
insert into WEBFLUX.item (id, name)
values (300, 'Common seal');
insert into WEBFLUX.item (id, name)
values (301, 'Bald eagle');
insert into WEBFLUX.item (id, name)
values (302, 'Common zebra');
insert into WEBFLUX.item (id, name)
values (303, 'Vulture, oriental white-backed');
insert into WEBFLUX.item (id, name)
values (304, 'Grouse, sage');
insert into WEBFLUX.item (id, name)
values (305, 'Four-spotted skimmer');
insert into WEBFLUX.item (id, name)
values (306, 'Flamingo, greater');
insert into WEBFLUX.item (id, name)
values (307, 'Dog, bush');
insert into WEBFLUX.item (id, name)
values (308, 'Short-nosed bandicoot');
insert into WEBFLUX.item (id, name)
values (309, 'Crested bunting');
insert into WEBFLUX.item (id, name)
values (310, 'Cape Barren goose');
insert into WEBFLUX.item (id, name)
values (311, 'Bulbul, black-eyed');
insert into WEBFLUX.item (id, name)
values (312, 'Nubian bee-eater');
insert into WEBFLUX.item (id, name)
values (313, 'Ring dove');
insert into WEBFLUX.item (id, name)
values (314, 'Sloth, pale-throated three-toed');
insert into WEBFLUX.item (id, name)
values (315, 'Gila monster');
insert into WEBFLUX.item (id, name)
values (316, 'Jaguar');
insert into WEBFLUX.item (id, name)
values (317, 'Tawny frogmouth');
insert into WEBFLUX.item (id, name)
values (318, 'Paradoxure');
insert into WEBFLUX.item (id, name)
values (319, 'White-lipped peccary');
insert into WEBFLUX.item (id, name)
values (320, 'Pie, indian tree');
insert into WEBFLUX.item (id, name)
values (321, 'Western lowland gorilla');
insert into WEBFLUX.item (id, name)
values (322, 'Macaw, green-winged');
insert into WEBFLUX.item (id, name)
values (323, 'Monkey, vervet');
insert into WEBFLUX.item (id, name)
values (324, 'Brown and yellow marshbird');
insert into WEBFLUX.item (id, name)
values (325, 'Coyote');
insert into WEBFLUX.item (id, name)
values (326, 'Red-necked wallaby');
insert into WEBFLUX.item (id, name)
values (327, 'Oryx, fringe-eared');
insert into WEBFLUX.item (id, name)
values (328, 'Kangaroo, jungle');
insert into WEBFLUX.item (id, name)
values (329, 'Nilgai');
insert into WEBFLUX.item (id, name)
values (330, 'Lizard, collared');
insert into WEBFLUX.item (id, name)
values (331, 'Guanaco');
insert into WEBFLUX.item (id, name)
values (332, 'White-bellied sea eagle');
insert into WEBFLUX.item (id, name)
values (333, 'Galapagos albatross');
insert into WEBFLUX.item (id, name)
values (334, 'Rhesus monkey');
insert into WEBFLUX.item (id, name)
values (335, 'Elephant, african');
insert into WEBFLUX.item (id, name)
values (336, 'Steller''s sea lion');
insert into WEBFLUX.item (id, name)
values (337, 'Hornbill, yellow-billed');
insert into WEBFLUX.item (id, name)
values (338, 'Vulture, oriental white-backed');
insert into WEBFLUX.item (id, name)
values (339, 'African polecat');
insert into WEBFLUX.item (id, name)
values (340, 'Genet, small-spotted');
insert into WEBFLUX.item (id, name)
values (341, 'Grison');
insert into WEBFLUX.item (id, name)
values (342, 'Hyena, brown');
insert into WEBFLUX.item (id, name)
values (343, 'Sarus crane');
insert into WEBFLUX.item (id, name)
values (344, 'Baboon, yellow');
insert into WEBFLUX.item (id, name)
values (345, 'African bush squirrel');
insert into WEBFLUX.item (id, name)
values (346, 'Avocet, pied');
insert into WEBFLUX.item (id, name)
values (347, 'Heron, gray');
insert into WEBFLUX.item (id, name)
values (348, 'Lapwing, southern');
insert into WEBFLUX.item (id, name)
values (349, 'Long-tailed skua');
insert into WEBFLUX.item (id, name)
values (350, 'Blue wildebeest');
insert into WEBFLUX.item (id, name)
values (351, 'Parakeet, rose-ringed');
insert into WEBFLUX.item (id, name)
values (352, 'Penguin, little blue');
insert into WEBFLUX.item (id, name)
values (353, 'Boa, malagasy ground');
insert into WEBFLUX.item (id, name)
values (354, 'Egyptian viper');
insert into WEBFLUX.item (id, name)
values (355, 'Hanuman langur');
insert into WEBFLUX.item (id, name)
values (356, 'Praying mantis (unidentified)');
insert into WEBFLUX.item (id, name)
values (357, 'Mouflon');
insert into WEBFLUX.item (id, name)
values (358, 'Antelope ground squirrel');
insert into WEBFLUX.item (id, name)
values (359, 'Racer, blue');
insert into WEBFLUX.item (id, name)
values (360, 'Skimmer, four-spotted');
insert into WEBFLUX.item (id, name)
values (361, 'Magnificent frigate bird');
insert into WEBFLUX.item (id, name)
values (362, 'Mandras tree shrew');
insert into WEBFLUX.item (id, name)
values (363, 'Nighthawk, common');
insert into WEBFLUX.item (id, name)
values (364, 'Parakeet, rose-ringed');
insert into WEBFLUX.item (id, name)
values (365, 'Southern brown bandicoot');
insert into WEBFLUX.item (id, name)
values (366, 'Southern sea lion');
insert into WEBFLUX.item (id, name)
values (367, 'Racer snake');
insert into WEBFLUX.item (id, name)
values (368, 'Seal, northern fur');
insert into WEBFLUX.item (id, name)
values (369, 'Dromedary camel');
insert into WEBFLUX.item (id, name)
values (370, 'Tern, white-winged black');
insert into WEBFLUX.item (id, name)
values (371, 'Vulture, egyptian');
insert into WEBFLUX.item (id, name)
values (372, 'Civet cat');
insert into WEBFLUX.item (id, name)
values (373, 'Turaco, violet-crested');
insert into WEBFLUX.item (id, name)
values (374, 'Hornbill, southern ground');
insert into WEBFLUX.item (id, name)
values (375, 'Curve-billed thrasher');
insert into WEBFLUX.item (id, name)
values (376, 'Mongoose, banded');
insert into WEBFLUX.item (id, name)
values (377, 'Anteater, australian spiny');
insert into WEBFLUX.item (id, name)
values (378, 'Lizard, giant girdled');
insert into WEBFLUX.item (id, name)
values (379, 'Albatross, galapagos');
insert into WEBFLUX.item (id, name)
values (380, 'Tawny frogmouth');
insert into WEBFLUX.item (id, name)
values (381, 'Bird, magnificent frigate');
insert into WEBFLUX.item (id, name)
values (382, 'Monster, gila');
insert into WEBFLUX.item (id, name)
values (383, 'Stork, marabou');
insert into WEBFLUX.item (id, name)
values (384, 'Buffalo, american');
insert into WEBFLUX.item (id, name)
values (385, 'Snowy owl');
insert into WEBFLUX.item (id, name)
values (386, 'Long-tailed skua');
insert into WEBFLUX.item (id, name)
values (387, 'Australian sea lion');
insert into WEBFLUX.item (id, name)
values (388, 'Rhinoceros, white');
insert into WEBFLUX.item (id, name)
values (389, 'Goose, spur-winged');
insert into WEBFLUX.item (id, name)
values (390, 'Southern elephant seal');
insert into WEBFLUX.item (id, name)
values (391, 'Jungle kangaroo');
insert into WEBFLUX.item (id, name)
values (392, 'Brindled gnu');
insert into WEBFLUX.item (id, name)
values (393, 'Slender-billed cockatoo');
insert into WEBFLUX.item (id, name)
values (394, 'Jungle kangaroo');
insert into WEBFLUX.item (id, name)
values (395, 'Pig-tailed macaque');
insert into WEBFLUX.item (id, name)
values (396, 'Echidna, short-beaked');
insert into WEBFLUX.item (id, name)
values (397, 'Anaconda (unidentified)');
insert into WEBFLUX.item (id, name)
values (398, 'Common goldeneye');
insert into WEBFLUX.item (id, name)
values (399, 'Klipspringer');
insert into WEBFLUX.item (id, name)
values (400, 'Baboon, gelada');
insert into WEBFLUX.item (id, name)
values (401, 'Common wallaroo');
insert into WEBFLUX.item (id, name)
values (402, 'Hornbill, leadbeateri''s ground');
insert into WEBFLUX.item (id, name)
values (403, 'Malagasy ground boa');
insert into WEBFLUX.item (id, name)
values (404, 'Swainson''s francolin');
insert into WEBFLUX.item (id, name)
values (405, 'Sheep, red');
insert into WEBFLUX.item (id, name)
values (406, 'Black-tailed prairie dog');
insert into WEBFLUX.item (id, name)
values (407, 'Ringtail cat');
insert into WEBFLUX.item (id, name)
values (408, 'Eastern grey kangaroo');
insert into WEBFLUX.item (id, name)
values (409, 'Chacma baboon');
insert into WEBFLUX.item (id, name)
values (410, 'Starling, greater blue-eared');
insert into WEBFLUX.item (id, name)
values (411, 'Jackrabbit, white-tailed');
insert into WEBFLUX.item (id, name)
values (412, 'Goose, egyptian');
insert into WEBFLUX.item (id, name)
values (413, 'Seal, harbor');
insert into WEBFLUX.item (id, name)
values (414, 'Great horned owl');
insert into WEBFLUX.item (id, name)
values (415, 'Paca');
insert into WEBFLUX.item (id, name)
values (416, 'Eastern indigo snake');
insert into WEBFLUX.item (id, name)
values (417, 'Dunnart, fat-tailed');
insert into WEBFLUX.item (id, name)
values (418, 'Salmon, sockeye');
insert into WEBFLUX.item (id, name)
values (419, 'Antelope, four-horned');
insert into WEBFLUX.item (id, name)
values (420, 'Golden eagle');
insert into WEBFLUX.item (id, name)
values (421, 'Silver-backed jackal');
insert into WEBFLUX.item (id, name)
values (422, 'Lizard, blue-tongued');
insert into WEBFLUX.item (id, name)
values (423, 'Kingfisher, white-throated');
insert into WEBFLUX.item (id, name)
values (424, 'White stork');
insert into WEBFLUX.item (id, name)
values (425, 'Cuis');
insert into WEBFLUX.item (id, name)
values (426, 'Civet, small-toothed palm');
insert into WEBFLUX.item (id, name)
values (427, 'Giraffe');
insert into WEBFLUX.item (id, name)
values (428, 'Snake, buttermilk');
insert into WEBFLUX.item (id, name)
values (429, 'Marmot, yellow-bellied');
insert into WEBFLUX.item (id, name)
values (430, 'Darter, african');
insert into WEBFLUX.item (id, name)
values (431, 'Lava gull');
insert into WEBFLUX.item (id, name)
values (432, 'Lion, asian');
insert into WEBFLUX.item (id, name)
values (433, 'Yellow-necked spurfowl');
insert into WEBFLUX.item (id, name)
values (434, 'Gazer, sun');
insert into WEBFLUX.item (id, name)
values (435, 'Cobra, cape');
insert into WEBFLUX.item (id, name)
values (436, 'Spur-winged goose');
insert into WEBFLUX.item (id, name)
values (437, 'Spoonbill, european');
insert into WEBFLUX.item (id, name)
values (438, 'Wolf, timber');
insert into WEBFLUX.item (id, name)
values (439, 'Heron, boat-billed');
insert into WEBFLUX.item (id, name)
values (440, 'Common zebra');
insert into WEBFLUX.item (id, name)
values (441, 'Black-tailed prairie dog');
insert into WEBFLUX.item (id, name)
values (442, 'Blue waxbill');
insert into WEBFLUX.item (id, name)
values (443, 'Small-toothed palm civet');
insert into WEBFLUX.item (id, name)
values (444, 'Phascogale, red-tailed');
insert into WEBFLUX.item (id, name)
values (445, 'Purple grenadier');
insert into WEBFLUX.item (id, name)
values (446, 'Blackbird, red-winged');
insert into WEBFLUX.item (id, name)
values (447, 'Sun gazer');
insert into WEBFLUX.item (id, name)
values (448, 'Laughing dove');
insert into WEBFLUX.item (id, name)
values (449, 'Collared lizard');
insert into WEBFLUX.item (id, name)
values (450, 'Baboon, savanna');
insert into WEBFLUX.item (id, name)
values (451, 'Caribou');
insert into WEBFLUX.item (id, name)
values (452, 'Deer, barasingha');
insert into WEBFLUX.item (id, name)
values (453, 'Woodpecker, downy');
insert into WEBFLUX.item (id, name)
values (454, 'Boubou, southern');
insert into WEBFLUX.item (id, name)
values (455, 'Duck, mountain');
insert into WEBFLUX.item (id, name)
values (456, 'Dolphin, common');
insert into WEBFLUX.item (id, name)
values (457, 'Lizard, desert spiny');
insert into WEBFLUX.item (id, name)
values (458, 'Brush-tailed rat kangaroo');
insert into WEBFLUX.item (id, name)
values (459, 'Small-clawed otter');
insert into WEBFLUX.item (id, name)
values (460, 'Stork, white-necked');
insert into WEBFLUX.item (id, name)
values (461, 'Stanley bustard');
insert into WEBFLUX.item (id, name)
values (462, 'Eagle, bald');
insert into WEBFLUX.item (id, name)
values (463, 'Macaque, rhesus');
insert into WEBFLUX.item (id, name)
values (464, 'Squirrel, antelope ground');
insert into WEBFLUX.item (id, name)
values (465, 'Giant girdled lizard');
insert into WEBFLUX.item (id, name)
values (466, 'Tortoise, galapagos');
insert into WEBFLUX.item (id, name)
values (467, 'Cockatoo, slender-billed');
insert into WEBFLUX.item (id, name)
values (468, 'Elephant, asian');
insert into WEBFLUX.item (id, name)
values (469, 'Baboon, savanna');
insert into WEBFLUX.item (id, name)
values (470, 'Eastern cottontail rabbit');
insert into WEBFLUX.item (id, name)
values (471, 'Bushbaby, large-eared');
insert into WEBFLUX.item (id, name)
values (472, 'Pied cormorant');
insert into WEBFLUX.item (id, name)
values (473, 'Groundhog');
insert into WEBFLUX.item (id, name)
values (474, 'Lemur, brown');
insert into WEBFLUX.item (id, name)
values (475, 'Green-backed heron');
insert into WEBFLUX.item (id, name)
values (476, 'Guanaco');
insert into WEBFLUX.item (id, name)
values (477, 'Ring dove');
insert into WEBFLUX.item (id, name)
values (478, 'Black-cheeked waxbill');
insert into WEBFLUX.item (id, name)
values (479, 'Hawk, red-tailed');
insert into WEBFLUX.item (id, name)
values (480, 'Ostrich');
insert into WEBFLUX.item (id, name)
values (481, 'Plover, three-banded');
insert into WEBFLUX.item (id, name)
values (482, 'Steller sea lion');
insert into WEBFLUX.item (id, name)
values (483, 'Stick insect');
insert into WEBFLUX.item (id, name)
values (484, 'White-throated monitor');
insert into WEBFLUX.item (id, name)
values (485, 'Bateleur eagle');
insert into WEBFLUX.item (id, name)
values (486, 'Fisher');
insert into WEBFLUX.item (id, name)
values (487, 'Blue waxbill');
insert into WEBFLUX.item (id, name)
values (488, 'Paca');
insert into WEBFLUX.item (id, name)
values (489, 'Admiral, indian red');
insert into WEBFLUX.item (id, name)
values (490, 'Viper, egyptian');
insert into WEBFLUX.item (id, name)
values (491, 'Seal, northern fur');
insert into WEBFLUX.item (id, name)
values (492, 'Scaly-breasted lorikeet');
insert into WEBFLUX.item (id, name)
values (493, 'Two-toed tree sloth');
insert into WEBFLUX.item (id, name)
values (494, 'Bird, bare-faced go away');
insert into WEBFLUX.item (id, name)
values (495, 'Gila monster');
insert into WEBFLUX.item (id, name)
values (496, 'Capuchin, white-fronted');
insert into WEBFLUX.item (id, name)
values (497, 'White-necked stork');
insert into WEBFLUX.item (id, name)
values (498, 'Dragon, ornate rock');
insert into WEBFLUX.item (id, name)
values (499, 'Porcupine, north american');
insert into WEBFLUX.item (id, name)
values (500, 'Red-winged hawk (unidentified)');
insert into WEBFLUX.item (id, name)
values (501, 'Dragon, ornate rock');
insert into WEBFLUX.item (id, name)
values (502, 'Waved albatross');
insert into WEBFLUX.item (id, name)
values (503, 'Salmon, sockeye');
insert into WEBFLUX.item (id, name)
values (504, 'Warthog');
insert into WEBFLUX.item (id, name)
values (505, 'Long-finned pilot whale');
insert into WEBFLUX.item (id, name)
values (506, 'Vulture, egyptian');
insert into WEBFLUX.item (id, name)
values (507, 'Crane, brolga');
insert into WEBFLUX.item (id, name)
values (508, 'Otter, brazilian');
insert into WEBFLUX.item (id, name)
values (509, 'Dusky gull');
insert into WEBFLUX.item (id, name)
values (510, 'Gecko, barking');
insert into WEBFLUX.item (id, name)
values (511, 'Blackbird, red-winged');
insert into WEBFLUX.item (id, name)
values (512, 'Flicker, campo');
insert into WEBFLUX.item (id, name)
values (513, 'Screamer, southern');
insert into WEBFLUX.item (id, name)
values (514, 'Dingo');
insert into WEBFLUX.item (id, name)
values (515, 'Flicker, campo');
insert into WEBFLUX.item (id, name)
values (516, 'Golden-mantled ground squirrel');
insert into WEBFLUX.item (id, name)
values (517, 'Saddle-billed stork');
insert into WEBFLUX.item (id, name)
values (518, 'Capybara');
insert into WEBFLUX.item (id, name)
values (519, 'Caracara, yellow-headed');
insert into WEBFLUX.item (id, name)
values (520, 'Ferruginous hawk');
insert into WEBFLUX.item (id, name)
values (521, 'Antelope, four-horned');
insert into WEBFLUX.item (id, name)
values (522, 'Gull, dusky');
insert into WEBFLUX.item (id, name)
values (523, 'Long-crested hawk eagle');
insert into WEBFLUX.item (id, name)
values (524, 'Rattlesnake, horned');
insert into WEBFLUX.item (id, name)
values (525, 'Beisa oryx');
insert into WEBFLUX.item (id, name)
values (526, 'Ring-tailed coatimundi');
insert into WEBFLUX.item (id, name)
values (527, 'Gulls (unidentified)');
insert into WEBFLUX.item (id, name)
values (528, 'Great egret');
insert into WEBFLUX.item (id, name)
values (529, 'African lynx');
insert into WEBFLUX.item (id, name)
values (530, 'Gull, pacific');
insert into WEBFLUX.item (id, name)
values (531, 'Starfish, crown of thorns');
insert into WEBFLUX.item (id, name)
values (532, 'Common nighthawk');
insert into WEBFLUX.item (id, name)
values (533, 'Eagle, pallas''s fish');
insert into WEBFLUX.item (id, name)
values (534, 'Anteater, giant');
insert into WEBFLUX.item (id, name)
values (535, 'Nutcracker, clark''s');
insert into WEBFLUX.item (id, name)
values (536, 'Shark, blue');
insert into WEBFLUX.item (id, name)
values (537, 'Red-capped cardinal');
insert into WEBFLUX.item (id, name)
values (538, 'Boar, wild');
insert into WEBFLUX.item (id, name)
values (539, 'Polecat, african');
insert into WEBFLUX.item (id, name)
values (540, 'Tenrec, tailless');
insert into WEBFLUX.item (id, name)
values (541, 'African buffalo');
insert into WEBFLUX.item (id, name)
values (542, 'Pacific gull');
insert into WEBFLUX.item (id, name)
values (543, 'Asian openbill');
insert into WEBFLUX.item (id, name)
values (544, 'Yellow baboon');
insert into WEBFLUX.item (id, name)
values (545, 'Timber wolf');
insert into WEBFLUX.item (id, name)
values (546, 'Hen, sage');
insert into WEBFLUX.item (id, name)
values (547, 'Cormorant, javanese');
insert into WEBFLUX.item (id, name)
values (548, 'Marshbird, brown and yellow');
insert into WEBFLUX.item (id, name)
values (549, 'Mule deer');
insert into WEBFLUX.item (id, name)
values (550, 'Tarantula, salmon pink bird eater');
insert into WEBFLUX.item (id, name)
values (551, 'Dog, black-tailed prairie');
insert into WEBFLUX.item (id, name)
values (552, 'Yellow-necked spurfowl');
insert into WEBFLUX.item (id, name)
values (553, 'Lemming, arctic');
insert into WEBFLUX.item (id, name)
values (554, 'Ringtail cat');
insert into WEBFLUX.item (id, name)
values (555, 'Booby, blue-footed');
insert into WEBFLUX.item (id, name)
values (556, 'Red kangaroo');
insert into WEBFLUX.item (id, name)
values (557, 'Vulture, white-rumped');
insert into WEBFLUX.item (id, name)
values (558, 'Grey fox');
insert into WEBFLUX.item (id, name)
values (559, 'Phascogale, brush-tailed');
insert into WEBFLUX.item (id, name)
values (560, 'Long-tailed spotted cat');
insert into WEBFLUX.item (id, name)
values (561, 'Gray duiker');
insert into WEBFLUX.item (id, name)
values (562, 'Dragon, frilled');
insert into WEBFLUX.item (id, name)
values (563, 'Crane, blue');
insert into WEBFLUX.item (id, name)
values (564, 'Gecko, tokay');
insert into WEBFLUX.item (id, name)
values (565, 'Dragon, ornate rock');
insert into WEBFLUX.item (id, name)
values (566, 'Cat, tiger');
insert into WEBFLUX.item (id, name)
values (567, 'Oribi');
insert into WEBFLUX.item (id, name)
values (568, 'Plover, three-banded');
insert into WEBFLUX.item (id, name)
values (569, 'Agouti');
insert into WEBFLUX.item (id, name)
values (570, 'Long-crested hawk eagle');
insert into WEBFLUX.item (id, name)
values (571, 'Suricate');
insert into WEBFLUX.item (id, name)
values (572, 'Hoary marmot');
insert into WEBFLUX.item (id, name)
values (573, 'Pine siskin');
insert into WEBFLUX.item (id, name)
values (574, 'Yellow baboon');
insert into WEBFLUX.item (id, name)
values (575, 'Eastern indigo snake');
insert into WEBFLUX.item (id, name)
values (576, 'Black-tailed tree creeper');
insert into WEBFLUX.item (id, name)
values (577, 'Stork, white');
insert into WEBFLUX.item (id, name)
values (578, 'Seal, southern elephant');
insert into WEBFLUX.item (id, name)
values (579, 'Great kiskadee');
insert into WEBFLUX.item (id, name)
values (580, 'Thrasher, curve-billed');
insert into WEBFLUX.item (id, name)
values (581, 'Sparrow, house');
insert into WEBFLUX.item (id, name)
values (582, 'Lizard, giant girdled');
insert into WEBFLUX.item (id, name)
values (583, 'Otter, african clawless');
insert into WEBFLUX.item (id, name)
values (584, 'African fish eagle');
insert into WEBFLUX.item (id, name)
values (585, 'Flycatcher, tyrant');
insert into WEBFLUX.item (id, name)
values (586, 'Deer, savannah');
insert into WEBFLUX.item (id, name)
values (587, 'Common melba finch');
insert into WEBFLUX.item (id, name)
values (588, 'Jackal, golden');
insert into WEBFLUX.item (id, name)
values (589, 'Dusky gull');
insert into WEBFLUX.item (id, name)
values (590, 'Iguana, common green');
insert into WEBFLUX.item (id, name)
values (591, 'Small-spotted genet');
insert into WEBFLUX.item (id, name)
values (592, 'Whale, killer');
insert into WEBFLUX.item (id, name)
values (593, 'Water legaan');
insert into WEBFLUX.item (id, name)
values (594, 'Common dolphin');
insert into WEBFLUX.item (id, name)
values (595, 'Badger, eurasian');
insert into WEBFLUX.item (id, name)
values (596, 'Small-spotted genet');
insert into WEBFLUX.item (id, name)
values (597, 'Elk, Wapiti');
insert into WEBFLUX.item (id, name)
values (598, 'Butterfly, tropical buckeye');
insert into WEBFLUX.item (id, name)
values (599, 'Turtle (unidentified)');
insert into WEBFLUX.item (id, name)
values (600, 'Cockatoo, roseate');
insert into WEBFLUX.item (id, name)
values (601, 'Springhare');
insert into WEBFLUX.item (id, name)
values (602, 'Vulture, white-headed');
insert into WEBFLUX.item (id, name)
values (603, 'Southern lapwing');
insert into WEBFLUX.item (id, name)
values (604, 'Deer, savannah');
insert into WEBFLUX.item (id, name)
values (605, 'Dove, laughing');
insert into WEBFLUX.item (id, name)
values (606, 'Carpet python');
insert into WEBFLUX.item (id, name)
values (607, 'Blesbok');
insert into WEBFLUX.item (id, name)
values (608, 'Tortoise, burmese black mountain');
insert into WEBFLUX.item (id, name)
values (609, 'Eurasian hoopoe');
insert into WEBFLUX.item (id, name)
values (610, 'White-winged black tern');
insert into WEBFLUX.item (id, name)
values (611, 'Brown hyena');
insert into WEBFLUX.item (id, name)
values (612, 'Wild water buffalo');
insert into WEBFLUX.item (id, name)
values (613, 'Saddle-billed stork');
insert into WEBFLUX.item (id, name)
values (614, 'Cockatoo, long-billed');
insert into WEBFLUX.item (id, name)
values (615, 'Paradoxure');
insert into WEBFLUX.item (id, name)
values (616, 'Pampa gray fox');
insert into WEBFLUX.item (id, name)
values (617, 'Long-crested hawk eagle');
insert into WEBFLUX.item (id, name)
values (618, 'Australian spiny anteater');
insert into WEBFLUX.item (id, name)
values (619, 'Macaque, rhesus');
insert into WEBFLUX.item (id, name)
values (620, 'Vervet monkey');
insert into WEBFLUX.item (id, name)
values (621, 'Wallaby, whip-tailed');
insert into WEBFLUX.item (id, name)
values (622, 'Ringtail cat');
insert into WEBFLUX.item (id, name)
values (623, 'Coke''s hartebeest');
insert into WEBFLUX.item (id, name)
values (624, 'Pied kingfisher');
insert into WEBFLUX.item (id, name)
values (625, 'Bison, american');
insert into WEBFLUX.item (id, name)
values (626, 'Wambenger, red-tailed');
insert into WEBFLUX.item (id, name)
values (627, 'Raven, cape');
insert into WEBFLUX.item (id, name)
values (628, 'Campo flicker');
insert into WEBFLUX.item (id, name)
values (629, 'Ibis, sacred');
insert into WEBFLUX.item (id, name)
values (630, 'Squirrel, african bush');
insert into WEBFLUX.item (id, name)
values (631, 'Red-billed hornbill');
insert into WEBFLUX.item (id, name)
values (632, 'African ground squirrel (unidentified)');
insert into WEBFLUX.item (id, name)
values (633, 'Trumpeter swan');
insert into WEBFLUX.item (id, name)
values (634, 'Tawny eagle');
insert into WEBFLUX.item (id, name)
values (635, 'Elegant crested tinamou');
insert into WEBFLUX.item (id, name)
values (636, 'Squirrel, thirteen-lined');
insert into WEBFLUX.item (id, name)
values (637, 'Black vulture');
insert into WEBFLUX.item (id, name)
values (638, 'Urial');
insert into WEBFLUX.item (id, name)
values (639, 'Mexican wolf');
insert into WEBFLUX.item (id, name)
values (640, 'Two-toed sloth');
insert into WEBFLUX.item (id, name)
values (641, 'Dog, african wild');
insert into WEBFLUX.item (id, name)
values (642, 'European shelduck');
insert into WEBFLUX.item (id, name)
values (643, 'Vulture, turkey');
insert into WEBFLUX.item (id, name)
values (644, 'Iguana, land');
insert into WEBFLUX.item (id, name)
values (645, 'Pheasant, common');
insert into WEBFLUX.item (id, name)
values (646, 'Gorilla, western lowland');
insert into WEBFLUX.item (id, name)
values (647, 'Long-tailed skua');
insert into WEBFLUX.item (id, name)
values (648, 'Pied crow');
insert into WEBFLUX.item (id, name)
values (649, 'Genoveva');
insert into WEBFLUX.item (id, name)
values (650, 'Rhinoceros, square-lipped');
insert into WEBFLUX.item (id, name)
values (651, 'Openbill stork');
insert into WEBFLUX.item (id, name)
values (652, 'Serval');
insert into WEBFLUX.item (id, name)
values (653, 'Stork, white-necked');
insert into WEBFLUX.item (id, name)
values (654, 'Pheasant, common');
insert into WEBFLUX.item (id, name)
values (655, 'Dog, african wild');
insert into WEBFLUX.item (id, name)
values (656, 'Lemur, brown');
insert into WEBFLUX.item (id, name)
values (657, 'Seal, southern elephant');
insert into WEBFLUX.item (id, name)
values (658, 'Seal, harbor');
insert into WEBFLUX.item (id, name)
values (659, 'Thrasher, curve-billed');
insert into WEBFLUX.item (id, name)
values (660, 'Darter, african');
insert into WEBFLUX.item (id, name)
values (661, 'Waxbill, violet-eared');
insert into WEBFLUX.item (id, name)
values (662, 'Crake, african black');
insert into WEBFLUX.item (id, name)
values (663, 'Ring-necked pheasant');
insert into WEBFLUX.item (id, name)
values (664, 'Onager');
insert into WEBFLUX.item (id, name)
values (665, 'Tawny frogmouth');
insert into WEBFLUX.item (id, name)
values (666, 'Southern sea lion');
insert into WEBFLUX.item (id, name)
values (667, 'Cougar');
insert into WEBFLUX.item (id, name)
values (668, 'Squirrel, arctic ground');
insert into WEBFLUX.item (id, name)
values (669, 'Oryx, beisa');
insert into WEBFLUX.item (id, name)
values (670, 'Buffalo, wild water');
insert into WEBFLUX.item (id, name)
values (671, 'Jackal, silver-backed');
insert into WEBFLUX.item (id, name)
values (672, 'Badger, eurasian');
insert into WEBFLUX.item (id, name)
values (673, 'White-faced whistling duck');
insert into WEBFLUX.item (id, name)
values (674, 'Deer, red');
insert into WEBFLUX.item (id, name)
values (675, 'Water monitor');
insert into WEBFLUX.item (id, name)
values (676, 'Langur, common');
insert into WEBFLUX.item (id, name)
values (677, 'Tapir, brazilian');
insert into WEBFLUX.item (id, name)
values (678, 'Stone sheep');
insert into WEBFLUX.item (id, name)
values (679, 'Malleefowl');
insert into WEBFLUX.item (id, name)
values (680, 'Tortoise, burmese brown mountain');
insert into WEBFLUX.item (id, name)
values (681, 'Hawk, galapagos');
insert into WEBFLUX.item (id, name)
values (682, 'Eagle, african fish');
insert into WEBFLUX.item (id, name)
values (683, 'Blackbuck');
insert into WEBFLUX.item (id, name)
values (684, 'Eland, common');
insert into WEBFLUX.item (id, name)
values (685, 'Darter, african');
insert into WEBFLUX.item (id, name)
values (686, 'Avocet, pied');
insert into WEBFLUX.item (id, name)
values (687, 'Dog, bush');
insert into WEBFLUX.item (id, name)
values (688, 'Weeper capuchin');
insert into WEBFLUX.item (id, name)
values (689, 'Springbuck');
insert into WEBFLUX.item (id, name)
values (690, 'Gazelle, grant''s');
insert into WEBFLUX.item (id, name)
values (691, 'Great cormorant');
insert into WEBFLUX.item (id, name)
values (692, 'Sheathbill, snowy');
insert into WEBFLUX.item (id, name)
values (693, 'Common genet');
insert into WEBFLUX.item (id, name)
values (694, 'Cape Barren goose');
insert into WEBFLUX.item (id, name)
values (695, 'Southern black-backed gull');
insert into WEBFLUX.item (id, name)
values (696, 'Kaffir cat');
insert into WEBFLUX.item (id, name)
values (697, 'Herring gull');
insert into WEBFLUX.item (id, name)
values (698, 'Long-tailed jaeger');
insert into WEBFLUX.item (id, name)
values (699, 'Leadbeateri''s ground hornbill');
insert into WEBFLUX.item (id, name)
values (700, 'Green-backed heron');
insert into WEBFLUX.item (id, name)
values (701, 'Gray rhea');
insert into WEBFLUX.item (id, name)
values (702, 'Galapagos mockingbird');
insert into WEBFLUX.item (id, name)
values (703, 'Heron, gray');
insert into WEBFLUX.item (id, name)
values (704, 'Gaur');
insert into WEBFLUX.item (id, name)
values (705, 'Viper, egyptian');
insert into WEBFLUX.item (id, name)
values (706, 'Cougar');
insert into WEBFLUX.item (id, name)
values (707, 'Buffalo, asian water');
insert into WEBFLUX.item (id, name)
values (708, 'Vulture, white-headed');
insert into WEBFLUX.item (id, name)
values (709, 'Yellow-throated sandgrouse');
insert into WEBFLUX.item (id, name)
values (710, 'Cat, cape wild');
insert into WEBFLUX.item (id, name)
values (711, 'Sun gazer');
insert into WEBFLUX.item (id, name)
values (712, 'Vine snake (unidentified)');
insert into WEBFLUX.item (id, name)
values (713, 'Dragon, asian water');
insert into WEBFLUX.item (id, name)
values (714, 'Tyrant flycatcher');
insert into WEBFLUX.item (id, name)
values (715, 'Dragon, ornate rock');
insert into WEBFLUX.item (id, name)
values (716, 'Adouri (unidentified)');
insert into WEBFLUX.item (id, name)
values (717, 'African pied wagtail');
insert into WEBFLUX.item (id, name)
values (718, 'Squirrel, grey-footed');
insert into WEBFLUX.item (id, name)
values (719, 'Fox, arctic');
insert into WEBFLUX.item (id, name)
values (720, 'Iguana, marine');
insert into WEBFLUX.item (id, name)
values (721, 'Lion, australian sea');
insert into WEBFLUX.item (id, name)
values (722, 'Coatimundi, white-nosed');
insert into WEBFLUX.item (id, name)
values (723, 'Heron, black-crowned night');
insert into WEBFLUX.item (id, name)
values (724, 'Black-tailed deer');
insert into WEBFLUX.item (id, name)
values (725, 'Fairy penguin');
insert into WEBFLUX.item (id, name)
values (726, 'Monkey, red howler');
insert into WEBFLUX.item (id, name)
values (727, 'Fox, arctic');
insert into WEBFLUX.item (id, name)
values (728, 'Antelope, sable');
insert into WEBFLUX.item (id, name)
values (729, 'Spider, wolf');
insert into WEBFLUX.item (id, name)
values (730, 'Viper, egyptian');
insert into WEBFLUX.item (id, name)
values (731, 'Bengal vulture');
insert into WEBFLUX.item (id, name)
values (732, 'Common zebra');
insert into WEBFLUX.item (id, name)
values (733, 'Boar, wild');
insert into WEBFLUX.item (id, name)
values (734, 'Little blue penguin');
insert into WEBFLUX.item (id, name)
values (735, 'Stilt, black-winged');
insert into WEBFLUX.item (id, name)
values (736, 'Australian sea lion');
insert into WEBFLUX.item (id, name)
values (737, 'Sea birds (unidentified)');
insert into WEBFLUX.item (id, name)
values (738, 'Pied avocet');
insert into WEBFLUX.item (id, name)
values (739, 'Southern lapwing');
insert into WEBFLUX.item (id, name)
values (740, 'Lesser masked weaver');
insert into WEBFLUX.item (id, name)
values (741, 'Monitor, white-throated');
insert into WEBFLUX.item (id, name)
values (742, 'American crow');
insert into WEBFLUX.item (id, name)
values (743, 'Cockatoo, red-breasted');
insert into WEBFLUX.item (id, name)
values (744, 'Monitor, two-banded');
insert into WEBFLUX.item (id, name)
values (745, 'Jacana, african');
insert into WEBFLUX.item (id, name)
values (746, 'South African hedgehog');
insert into WEBFLUX.item (id, name)
values (747, 'Dragon, western bearded');
insert into WEBFLUX.item (id, name)
values (748, 'Plover, three-banded');
insert into WEBFLUX.item (id, name)
values (749, 'Rufous-collared sparrow');
insert into WEBFLUX.item (id, name)
values (750, 'Laughing kookaburra');
insert into WEBFLUX.item (id, name)
values (751, 'Cobra, egyptian');
insert into WEBFLUX.item (id, name)
values (752, 'Green-backed heron');
insert into WEBFLUX.item (id, name)
values (753, 'Phalarope, red');
insert into WEBFLUX.item (id, name)
values (754, 'Bandicoot, southern brown');
insert into WEBFLUX.item (id, name)
values (755, 'White-necked raven');
insert into WEBFLUX.item (id, name)
values (756, 'Bat, madagascar fruit');
insert into WEBFLUX.item (id, name)
values (757, 'Crane, stanley');
insert into WEBFLUX.item (id, name)
values (758, 'Jackal, silver-backed');
insert into WEBFLUX.item (id, name)
values (759, 'Stick insect');
insert into WEBFLUX.item (id, name)
values (760, 'Capuchin, weeper');
insert into WEBFLUX.item (id, name)
values (761, 'Glider, sugar');
insert into WEBFLUX.item (id, name)
values (762, 'Waved albatross');
insert into WEBFLUX.item (id, name)
values (763, 'Euro wallaby');
insert into WEBFLUX.item (id, name)
values (764, 'Jackal, silver-backed');
insert into WEBFLUX.item (id, name)
values (765, 'Lemur, grey mouse');
insert into WEBFLUX.item (id, name)
values (766, 'Red-shouldered glossy starling');
insert into WEBFLUX.item (id, name)
values (767, 'Gambel''s quail');
insert into WEBFLUX.item (id, name)
values (768, 'Pied crow');
insert into WEBFLUX.item (id, name)
values (769, 'Fringe-eared oryx');
insert into WEBFLUX.item (id, name)
values (770, 'Red meerkat');
insert into WEBFLUX.item (id, name)
values (771, 'White rhinoceros');
insert into WEBFLUX.item (id, name)
values (772, 'Bettong, brush-tailed');
insert into WEBFLUX.item (id, name)
values (773, 'Crested porcupine');
insert into WEBFLUX.item (id, name)
values (774, 'Brush-tailed phascogale');
insert into WEBFLUX.item (id, name)
values (775, 'Currasow (unidentified)');
insert into WEBFLUX.item (id, name)
values (776, 'Racer snake');
insert into WEBFLUX.item (id, name)
values (777, 'Potoroo');
insert into WEBFLUX.item (id, name)
values (778, 'Yellow mongoose');
insert into WEBFLUX.item (id, name)
values (779, 'Cormorant (unidentified)');
insert into WEBFLUX.item (id, name)
values (780, 'Malachite kingfisher');
insert into WEBFLUX.item (id, name)
values (781, 'Cat, cape wild');
insert into WEBFLUX.item (id, name)
values (782, 'Potoroo');
insert into WEBFLUX.item (id, name)
values (783, 'Zorilla');
insert into WEBFLUX.item (id, name)
values (784, 'Boa, mexican');
insert into WEBFLUX.item (id, name)
values (785, 'Cormorant, pied');
insert into WEBFLUX.item (id, name)
values (786, 'Otter, canadian river');
insert into WEBFLUX.item (id, name)
values (787, 'Four-striped grass mouse');
insert into WEBFLUX.item (id, name)
values (788, 'Greater roadrunner');
insert into WEBFLUX.item (id, name)
values (789, 'Galapagos mockingbird');
insert into WEBFLUX.item (id, name)
values (790, 'Legaan, water');
insert into WEBFLUX.item (id, name)
values (791, 'Western spotted skunk');
insert into WEBFLUX.item (id, name)
values (792, 'Horned puffin');
insert into WEBFLUX.item (id, name)
values (793, 'Anaconda (unidentified)');
insert into WEBFLUX.item (id, name)
values (794, 'Francolin, swainson''s');
insert into WEBFLUX.item (id, name)
values (795, 'Black-throated butcher bird');
insert into WEBFLUX.item (id, name)
values (796, 'Bat-eared fox');
insert into WEBFLUX.item (id, name)
values (797, 'Southern screamer');
insert into WEBFLUX.item (id, name)
values (798, 'Monkey, vervet');
insert into WEBFLUX.item (id, name)
values (799, 'Carpet snake');
insert into WEBFLUX.item (id, name)
values (800, 'Stork, marabou');
insert into WEBFLUX.item (id, name)
values (801, 'Common goldeneye');
insert into WEBFLUX.item (id, name)
values (802, 'South American meadowlark (unidentified)');
insert into WEBFLUX.item (id, name)
values (803, 'Rose-ringed parakeet');
insert into WEBFLUX.item (id, name)
values (804, 'Dragon, netted rock');
insert into WEBFLUX.item (id, name)
values (805, 'Tammar wallaby');
insert into WEBFLUX.item (id, name)
values (806, 'Badger, american');
insert into WEBFLUX.item (id, name)
values (807, 'Dragon, western bearded');
insert into WEBFLUX.item (id, name)
values (808, 'Shrew, mandras tree');
insert into WEBFLUX.item (id, name)
values (809, 'Sable antelope');
insert into WEBFLUX.item (id, name)
values (810, 'Tern, white-winged');
insert into WEBFLUX.item (id, name)
values (811, 'Colobus, white-mantled');
insert into WEBFLUX.item (id, name)
values (812, 'Sheep, american bighorn');
insert into WEBFLUX.item (id, name)
values (813, 'Yellow mongoose');
insert into WEBFLUX.item (id, name)
values (814, 'Bottle-nose dolphin');
insert into WEBFLUX.item (id, name)
values (815, 'Topi');
insert into WEBFLUX.item (id, name)
values (816, 'Kangaroo, jungle');
insert into WEBFLUX.item (id, name)
values (817, 'Legaan, ground');
insert into WEBFLUX.item (id, name)
values (818, 'Western bearded dragon');
insert into WEBFLUX.item (id, name)
values (819, 'Sandgrouse, yellow-throated');
insert into WEBFLUX.item (id, name)
values (820, 'Roadrunner, greater');
insert into WEBFLUX.item (id, name)
values (821, 'Hedgehog, south african');
insert into WEBFLUX.item (id, name)
values (822, 'Monitor lizard (unidentified)');
insert into WEBFLUX.item (id, name)
values (823, 'Rhea, common');
insert into WEBFLUX.item (id, name)
values (824, 'Sea birds (unidentified)');
insert into WEBFLUX.item (id, name)
values (825, 'Great egret');
insert into WEBFLUX.item (id, name)
values (826, 'Miner''s cat');
insert into WEBFLUX.item (id, name)
values (827, 'House crow');
insert into WEBFLUX.item (id, name)
values (828, 'Raven, white-necked');
insert into WEBFLUX.item (id, name)
values (829, 'African red-eyed bulbul');
insert into WEBFLUX.item (id, name)
values (830, 'Lapwing, southern');
insert into WEBFLUX.item (id, name)
values (831, 'Tree porcupine');
insert into WEBFLUX.item (id, name)
values (832, 'Grizzly bear');
insert into WEBFLUX.item (id, name)
values (833, 'Bat, little brown');
insert into WEBFLUX.item (id, name)
values (834, 'Koala');
insert into WEBFLUX.item (id, name)
values (835, 'Quoll, eastern');
insert into WEBFLUX.item (id, name)
values (836, 'Stork, black-necked');
insert into WEBFLUX.item (id, name)
values (837, 'Phascogale, red-tailed');
insert into WEBFLUX.item (id, name)
values (838, 'Boar, wild');
insert into WEBFLUX.item (id, name)
values (839, 'African fish eagle');
insert into WEBFLUX.item (id, name)
values (840, 'Mouse, four-striped grass');
insert into WEBFLUX.item (id, name)
values (841, 'Cat, toddy');
insert into WEBFLUX.item (id, name)
values (842, 'Black-footed ferret');
insert into WEBFLUX.item (id, name)
values (843, 'Hawk, galapagos');
insert into WEBFLUX.item (id, name)
values (844, 'Duck, white-faced whistling');
insert into WEBFLUX.item (id, name)
values (845, 'King cormorant');
insert into WEBFLUX.item (id, name)
values (846, 'Caracara, yellow-headed');
insert into WEBFLUX.item (id, name)
values (847, 'Beaver, north american');
insert into WEBFLUX.item (id, name)
values (848, 'Common brushtail possum');
insert into WEBFLUX.item (id, name)
values (849, 'Bat, asian false vampire');
insert into WEBFLUX.item (id, name)
values (850, 'Capuchin, weeper');
insert into WEBFLUX.item (id, name)
values (851, 'Squirrel, indian giant');
insert into WEBFLUX.item (id, name)
values (852, 'Ibis, glossy');
insert into WEBFLUX.item (id, name)
values (853, 'Brown and yellow marshbird');
insert into WEBFLUX.item (id, name)
values (854, 'Langur, common');
insert into WEBFLUX.item (id, name)
values (855, 'Bear, polar');
insert into WEBFLUX.item (id, name)
values (856, 'Striped hyena');
insert into WEBFLUX.item (id, name)
values (857, 'African jacana');
insert into WEBFLUX.item (id, name)
values (858, 'Spectacled caiman');
insert into WEBFLUX.item (id, name)
values (859, 'Common brushtail possum');
insert into WEBFLUX.item (id, name)
values (860, 'Hyena, brown');
insert into WEBFLUX.item (id, name)
values (861, 'Deer, red');
insert into WEBFLUX.item (id, name)
values (862, 'Monitor, two-banded');
insert into WEBFLUX.item (id, name)
values (863, 'Colobus, black and white');
insert into WEBFLUX.item (id, name)
values (864, 'Godwit, hudsonian');
insert into WEBFLUX.item (id, name)
values (865, 'Tern, white-winged');
insert into WEBFLUX.item (id, name)
values (866, 'Bulbul, african red-eyed');
insert into WEBFLUX.item (id, name)
values (867, 'Hyrax');
insert into WEBFLUX.item (id, name)
values (868, 'Rat, white-faced tree');
insert into WEBFLUX.item (id, name)
values (869, 'Small-clawed otter');
insert into WEBFLUX.item (id, name)
values (870, 'Black-capped capuchin');
insert into WEBFLUX.item (id, name)
values (871, 'Coqui partridge');
insert into WEBFLUX.item (id, name)
values (872, 'Goat, mountain');
insert into WEBFLUX.item (id, name)
values (873, 'African fish eagle');
insert into WEBFLUX.item (id, name)
values (874, 'Savannah deer');
insert into WEBFLUX.item (id, name)
values (875, 'Yellow mongoose');
insert into WEBFLUX.item (id, name)
values (876, 'Squirrel, palm');
insert into WEBFLUX.item (id, name)
values (877, 'Burmese black mountain tortoise');
insert into WEBFLUX.item (id, name)
values (878, 'Skua, long-tailed');
insert into WEBFLUX.item (id, name)
values (879, 'Black-backed magpie');
insert into WEBFLUX.item (id, name)
values (880, 'Ass, asiatic wild');
insert into WEBFLUX.item (id, name)
values (881, 'Starling, superb');
insert into WEBFLUX.item (id, name)
values (882, 'Heron, green-backed');
insert into WEBFLUX.item (id, name)
values (883, 'Mississippi alligator');
insert into WEBFLUX.item (id, name)
values (884, 'White-mantled colobus');
insert into WEBFLUX.item (id, name)
values (885, 'Gray rhea');
insert into WEBFLUX.item (id, name)
values (886, 'Antelope, sable');
insert into WEBFLUX.item (id, name)
values (887, 'Bat, asian false vampire');
insert into WEBFLUX.item (id, name)
values (888, 'Rabbit, eastern cottontail');
insert into WEBFLUX.item (id, name)
values (889, 'Eastern boa constrictor');
insert into WEBFLUX.item (id, name)
values (890, 'Porcupine, indian');
insert into WEBFLUX.item (id, name)
values (891, 'Savannah deer (unidentified)');
insert into WEBFLUX.item (id, name)
values (892, 'Genet, small-spotted');
insert into WEBFLUX.item (id, name)
values (893, 'Large-eared bushbaby');
insert into WEBFLUX.item (id, name)
values (894, 'Skink, african');
insert into WEBFLUX.item (id, name)
values (895, 'Greater adjutant stork');
insert into WEBFLUX.item (id, name)
values (896, 'Galapagos penguin');
insert into WEBFLUX.item (id, name)
values (897, 'Comb duck');
insert into WEBFLUX.item (id, name)
values (898, 'Albatross, waved');
insert into WEBFLUX.item (id, name)
values (899, 'Pampa gray fox');
insert into WEBFLUX.item (id, name)
values (900, 'Flightless cormorant');
insert into WEBFLUX.item (id, name)
values (901, 'Black-crowned night heron');
insert into WEBFLUX.item (id, name)
values (902, 'Eurasian beaver');
insert into WEBFLUX.item (id, name)
values (903, 'Grizzly bear');
insert into WEBFLUX.item (id, name)
values (904, 'Boa, emerald green tree');
insert into WEBFLUX.item (id, name)
values (905, 'Wallaby, whip-tailed');
insert into WEBFLUX.item (id, name)
values (906, 'Common grenadier');
insert into WEBFLUX.item (id, name)
values (907, 'Cape raven');
insert into WEBFLUX.item (id, name)
values (908, 'Rose-ringed parakeet');
insert into WEBFLUX.item (id, name)
values (909, 'Sun gazer');
insert into WEBFLUX.item (id, name)
values (910, 'Flightless cormorant');
insert into WEBFLUX.item (id, name)
values (911, 'African wild dog');
insert into WEBFLUX.item (id, name)
values (912, 'Otter, canadian river');
insert into WEBFLUX.item (id, name)
values (913, 'Bird, red-billed tropic');
insert into WEBFLUX.item (id, name)
values (914, 'Red-tailed hawk');
insert into WEBFLUX.item (id, name)
values (915, 'Darwin ground finch (unidentified)');
insert into WEBFLUX.item (id, name)
values (916, 'Australian pelican');
insert into WEBFLUX.item (id, name)
values (917, 'European shelduck');
insert into WEBFLUX.item (id, name)
values (918, 'Red-knobbed coot');
insert into WEBFLUX.item (id, name)
values (919, 'Trumpeter, green-winged');
insert into WEBFLUX.item (id, name)
values (920, 'Mongoose, javan gold-spotted');
insert into WEBFLUX.item (id, name)
values (921, 'Gaur');
insert into WEBFLUX.item (id, name)
values (922, 'Caracara, yellow-headed');
insert into WEBFLUX.item (id, name)
values (923, 'Baleen whale');
insert into WEBFLUX.item (id, name)
values (924, 'Bird, red-billed tropic');
insert into WEBFLUX.item (id, name)
values (925, 'Vulture, white-headed');
insert into WEBFLUX.item (id, name)
values (926, 'Sacred ibis');
insert into WEBFLUX.item (id, name)
values (927, 'Yellow-rumped siskin');
insert into WEBFLUX.item (id, name)
values (928, 'Eastern grey kangaroo');
insert into WEBFLUX.item (id, name)
values (929, 'Eleven-banded armadillo (unidentified)');
insert into WEBFLUX.item (id, name)
values (930, 'Darter, african');
insert into WEBFLUX.item (id, name)
values (931, 'Wattled crane');
insert into WEBFLUX.item (id, name)
values (932, 'Flicker, field');
insert into WEBFLUX.item (id, name)
values (933, 'Lapwing (unidentified)');
insert into WEBFLUX.item (id, name)
values (934, 'Peccary, white-lipped');
insert into WEBFLUX.item (id, name)
values (935, 'Gull, swallow-tail');
insert into WEBFLUX.item (id, name)
values (936, 'Asian red fox');
insert into WEBFLUX.item (id, name)
values (937, 'Fox, crab-eating');
insert into WEBFLUX.item (id, name)
values (938, 'Japanese macaque');
insert into WEBFLUX.item (id, name)
values (939, 'Swainson''s francolin');
insert into WEBFLUX.item (id, name)
values (940, 'Crowned eagle');
insert into WEBFLUX.item (id, name)
values (941, 'Grant''s gazelle');
insert into WEBFLUX.item (id, name)
values (942, 'Stork, white');
insert into WEBFLUX.item (id, name)
values (943, 'Gull, swallow-tail');
insert into WEBFLUX.item (id, name)
values (944, 'Kangaroo, red');
insert into WEBFLUX.item (id, name)
values (945, 'Grey mouse lemur');
insert into WEBFLUX.item (id, name)
values (946, 'Silver gull');
insert into WEBFLUX.item (id, name)
values (947, 'Lemur, grey mouse');
insert into WEBFLUX.item (id, name)
values (948, 'Owl, snowy');
insert into WEBFLUX.item (id, name)
values (949, 'African darter');
insert into WEBFLUX.item (id, name)
values (950, 'Mississippi alligator');
insert into WEBFLUX.item (id, name)
values (951, 'White-bellied sea eagle');
insert into WEBFLUX.item (id, name)
values (952, 'Gull, herring');
insert into WEBFLUX.item (id, name)
values (953, 'Red-necked phalarope');
insert into WEBFLUX.item (id, name)
values (954, 'Marine iguana');
insert into WEBFLUX.item (id, name)
values (955, 'White-throated robin');
insert into WEBFLUX.item (id, name)
values (956, 'Arboral spiny rat');
insert into WEBFLUX.item (id, name)
values (957, 'Richardson''s ground squirrel');
insert into WEBFLUX.item (id, name)
values (958, 'Possum, golden brush-tailed');
insert into WEBFLUX.item (id, name)
values (959, 'Francolin, coqui');
insert into WEBFLUX.item (id, name)
values (960, 'Paradoxure');
insert into WEBFLUX.item (id, name)
values (961, 'Mallard');
insert into WEBFLUX.item (id, name)
values (962, 'Gazelle, grant''s');
insert into WEBFLUX.item (id, name)
values (963, 'Gecko, ring-tailed');
insert into WEBFLUX.item (id, name)
values (964, 'Jackal, golden');
insert into WEBFLUX.item (id, name)
values (965, 'Hawk-headed parrot');
insert into WEBFLUX.item (id, name)
values (966, 'Radiated tortoise');
insert into WEBFLUX.item (id, name)
values (967, 'Wagtail, african pied');
insert into WEBFLUX.item (id, name)
values (968, 'Baboon, gelada');
insert into WEBFLUX.item (id, name)
values (969, 'Galapagos hawk');
insert into WEBFLUX.item (id, name)
values (970, 'Desert tortoise');
insert into WEBFLUX.item (id, name)
values (971, 'Jaeger, long-tailed');
insert into WEBFLUX.item (id, name)
values (972, 'Grizzly bear');
insert into WEBFLUX.item (id, name)
values (973, 'Cobra, egyptian');
insert into WEBFLUX.item (id, name)
values (974, 'Australian magpie');
insert into WEBFLUX.item (id, name)
values (975, 'Black kite');
insert into WEBFLUX.item (id, name)
values (976, 'Avocet, pied');
insert into WEBFLUX.item (id, name)
values (977, 'Trumpeter, dark-winged');
insert into WEBFLUX.item (id, name)
values (978, 'Bent-toed gecko');
insert into WEBFLUX.item (id, name)
values (979, 'Antelope, roan');
insert into WEBFLUX.item (id, name)
values (980, 'African wild cat');
insert into WEBFLUX.item (id, name)
values (981, 'Pied avocet');
insert into WEBFLUX.item (id, name)
values (982, 'Hoary marmot');
insert into WEBFLUX.item (id, name)
values (983, 'Bushbaby, large-eared');
insert into WEBFLUX.item (id, name)
values (984, 'Jackal, black-backed');
insert into WEBFLUX.item (id, name)
values (985, 'Greater rhea');
insert into WEBFLUX.item (id, name)
values (986, 'Red-billed tropic bird');
insert into WEBFLUX.item (id, name)
values (987, 'Goldeneye, barrows');
insert into WEBFLUX.item (id, name)
values (988, 'Goose, cereopsis');
insert into WEBFLUX.item (id, name)
values (989, 'Asiatic jackal');
insert into WEBFLUX.item (id, name)
values (990, 'Denham''s bustard');
insert into WEBFLUX.item (id, name)
values (991, 'Green-backed heron');
insert into WEBFLUX.item (id, name)
values (992, 'Large-eared bushbaby');
insert into WEBFLUX.item (id, name)
values (993, 'Shrike, crimson-breasted');
insert into WEBFLUX.item (id, name)
values (994, 'Spotted wood sandpiper');
insert into WEBFLUX.item (id, name)
values (995, 'Phalarope, northern');
insert into WEBFLUX.item (id, name)
values (996, 'Mountain goat');
insert into WEBFLUX.item (id, name)
values (997, 'Musk ox');
insert into WEBFLUX.item (id, name)
values (998, 'Tayra');
insert into WEBFLUX.item (id, name)
values (999, 'Red-winged hawk (unidentified)');
insert into WEBFLUX.item (id, name)
values (1000, 'Blue-breasted cordon bleu');
