INSERT INTO customers
VALUES
	('bogholderi@delfinen.dk', 'Else', 'Thomsen'),
    ('lkof67@yahoo.com', 'Lise', 'Kofoed'),
    ('phelbsfan54@outlook.dk', 'John', 'Smith'),
    ('fuckseaworld@gmail.com', 'Bob', 'Williams');
    
INSERT INTO orders(customer_email)
VALUES
	('phelbsfan54@outlook.dk'),
    ('lkof67@yahoo.com'),
    ('phelbsfan54@outlook.dk'),
    ('phelbsfan54@outlook.dk'),
    ('fuckseaworld@gmail.com'),
    ('fuckseaworld@gmail.com'),
    ('bogholderi@delfinen.dk'),
    ('bogholderi@delfinen.dk'),
    ('bogholderi@delfinen.dk'),
    ('fuckseaworld@gmail.com');

INSERT INTO categories
VALUES
	('NUC'),
    ('Skærm'),
    ('Tastatur'),
    ('Mus'),
    ('SSD'),
    ('RAM');

INSERT INTO products
VALUES
	('0675901407687', 'Intel',	'NUC7I3BNH - Core i3 & 2.5" / M.2',				8,	1948,	'NUC',		'Intel NUC (The Next Unit of Computing), 2.4 GHz Intel Core i3-7100U Dual Core CPU (7. generations Core arkitektur - Baby Canyon), Uden RAM (SODIMM RAM DDR4-2133 - 2 x DIMM slots), Uden harddisk (OBS kræver M.2 2242 (42mm) / M.2 2280 (80mm) SSD & 1 x SATA-600 HDD / SSD), Indbygget Intel HD Graphics 620 grafikkort, 100/1000 MBIT netværk, Intel Dual-Band Wireless-AC 802.11ac trådløst netværk & Bluetooth 4.2, HDMI 2.0 / Mini DisplayPort 1.2 (via USB-C stik) tilslutning, 8 kanals surround lydkort'),
    ('5032037088770', 'Intel',	'NUC6CAYH - Celeron J3455',						12,	907,	'NUC',		'Intel NUC (The Next Unit of Computing), 1.5 GHz (2.3 GHz Turbo) Intel Celeron J3455 CPU, Uden RAM (SODIMM RAM DDR3L-1600 - 2 x DIMM slots), Uden harddisk (OBS kan opgraderes med 1 x M.2 2230 SSD & 1 x SATA-600 HDD / SSD), Indbygget Intel HD Graphics 500 grafikkort, 100/1000 MBIT netværk, Intel Dual-Band Wireless-AC 802.11ac trådløst netværk & Bluetooth 4.2, D-Sub / HDMI 2.0 tilslutning'),
    ('0675901407632', 'Intel',	'NUC7I5BNH - Core i5 & 2.5" / M.2',				6,	2636,	'NUC',		'Intel NUC (The Next Unit of Computing), 2.4 GHz (3.4 GHz Turbo) Intel Core i5-7260U Dual Core CPU (7. generations Core arkitektur - Baby Canyon), Uden RAM (SODIMM RAM DDR4-2133 - 2 x DIMM slots), Uden harddisk (OBS kræver M.2 2242 (42mm) / M.2 2280 (80mm) SSD - understøtter NVMe & 1 x SATA-600 HDD / SSD), Indbygget Intel Iris Plus Graphics 640 grafikkort, 100/1000 MBIT netværk, Intel Dual-Band Wireless-AC 802.11ac trådløst netværk & Bluetooth 4.2, HDMI 2.0 / Mini DisplayPort 1.2 (via USB-C stik) / ThunderBolt 3 (via USB-C stik) tilslutning, 8 kanals surround lydkort'),
    ('0675901407380', 'Intel',	'NUC7I7BNH - Core i7 & 2.5" / M.2',				2,	3367,	'NUC',		'Intel NUC (The Next Unit of Computing), 3.5 GHz (4 GHz Turbo) Intel Core i7-7567U Dual Core CPU (7. generations Core arkitektur - Kaby Lake ), Uden RAM (SODIMM RAM DDR4-2133 - 2 x DIMM slots), Uden harddisk (OBS kræver M.2 2242 (42mm) / M.2 2280 (80mm) SSD - understøtter NVMe & 1 x SATA-600 HDD / SSD), Indbygget Intel Iris Plus Graphics 650 grafikkort, 100/1000 MBIT netværk, Intel Dual-Band Wireless-AC 802.11ac trådløst netværk & Bluetooth 4.2, HDMI 2.0 / Mini DisplayPort 1.2 (via USB-C stik) / ThunderBolt 3 (via USB-C stik) tilslutning, 8 kanals surround lydkort'),
    ('0675901407427', 'Intel',	'NUC7I5BNK - Core i5 & M.2',					0,	2620,	'NUC',		'Intel NUC (The Next Unit of Computing), 2.4 GHz (3.4 GHz Turbo) Intel Core i5-7260U Dual Core CPU (7. generations Core arkitektur - Baby Canyon), Uden RAM (SODIMM RAM DDR4-2133 - 2 x DIMM slots), Uden harddisk (OBS kræver M.2 2242 (42mm) / M.2 2280 (80mm) SSD - understøtter NVMe), Indbygget Intel Iris Plus Graphics 640 grafikkort, 100/1000 MBIT netværk, Intel Dual-Band Wireless-AC 802.11ac trådløst netværk & Bluetooth 4.2, HDMI 2.0 / Mini DisplayPort 1.2 (via USB-C stik) / ThunderBolt 3 (via USB-C stik) tilslutning, 8 kanals surround lydkort'),
    ('8806087605099', 'LG',		'34" Skærm 34UM88C-P - Sort - 5 ms',			3,	4990,	'Skærm',	'LED-skærm, 34", 3440 x 1440 QHD, 60 hz opdatering, IPS panel, Widescreen 21:9 format, 300 cd/m2, 5000000:1 kontrast (dynamisk), 5 ms responstid, betragtningsvinkel: 178° (Horisontal) / 178° (Vertikal), DisplayPort / HDMI tilslutning, indbygget 7 watt højttalere, sort'),
    ('5397063966837', 'Dell',		'38" Skærm UltraSharp U3818DW - Sort - 5 ms',	0,	9216,	'Skærm',	'LED-skærm, kurvet, 38" (37.5 til at se), 3840 x 1600, IPS, 300 cd/m², 1000:1, 5 ms, 2xHDMI, DisplayPort, højtalere, sort'),
    ('0887942152888', 'Lenovo',	'24" Skærm ThinkVision LT2423 - Sort - 5 ms',	15,	1082,	'Skærm',	'LCD-skærm, 24", 1920 x 1080, TN, 250 cd/m2, 1000:1, 5 ms, højtalere, business-sort'),
    ('4713147477609', 'Acer',		'21" Skærm K222HQL - Sort - 5 ms',				0,	696,	'Skærm',	'LED-skærm, 21.5", 1920 x 1080 FullHD, TN, 200 cd/m2, 5 ms, HDMI, DVI, VGA, sort'),
    ('5397063744633', 'Dell',		'27" Skærm P2717H - Sort - 6 ms',				15, 1849,	'Skærm',	'LED-skærm, 27", 1920 x 1080, IPS, 300 cd/m2, 1000:1, 6 ms, HDMI, VGA, DisplayPort, sort'),
    ('5397063744220', 'Dell',		'27" Skærm UltraSharp U2717D - Sort - 6 ms',	4,	3346,	'Skærm',	'LED-skærm, 27", 2560 x 1440 QHD, IPS, 350 cd/m2, 1000:1, 6 ms, HDMI (MHL), DisplayPort, Mini DisplayPort, sort, HDMI, DisplayPort, Mini DisplayPort, Mobile High-Definition Link (MHL)'),
    ('5397063348053', 'Dell',		'24" Skærm UltraSharp U2414H - Sort - 8 ms',	15, 1749,	'Skærm',	'LED-skærm, 24", 1920 x 1080 FullHD, IPS, 250 cd/m2, 1000:1, 2000000:1 (dynamisk), 8 ms, DisplayPort, Mini DisplayPort, 2 x MHL, sort'),
    ('4716659551782', 'ASUS',		'24" Skærm VS247HR - Sort - 2 ms',				10, 953,	'Skærm',	'LED-skærm, 23.6", 1920 x 1080 FullHD, 75 hz opdatering, TN panel, Widescreen 16:9 format, 250 cd/m2 brightness, 50000000:1 kontrast (dynamisk), 2 ms responstid, betragtningsvinkel: 170° (Horisontal) / 160° (Vertikal), D-Sub / DVI-D / HDMI tilslutning, sort');/*
    (, '', '', , ., '', ''),
    (, '', '', , ., '', ''),
    (, '', '', , ., '', '');*/

SELECT * FROM products ORDER BY name