--
-- TOC entry 3469 (class 0 OID 347097)
-- Dependencies: 222
-- Data for Name: attr_group_dic; Type: TABLE DATA; Schema: public; Owner: admin
--

INSERT INTO public.attr_group_dic VALUES (1, 'Общие характеристики');
INSERT INTO public.attr_group_dic VALUES (2, 'Технические характеристики');


--
-- TOC entry 3473 (class 0 OID 347143)
-- Dependencies: 226
-- Data for Name: attr_value_dic; Type: TABLE DATA; Schema: public; Owner: admin
--



--
-- TOC entry 3472 (class 0 OID 347128)
-- Dependencies: 225
-- Data for Name: attribute; Type: TABLE DATA; Schema: public; Owner: admin
--



--
-- TOC entry 3470 (class 0 OID 347102)
-- Dependencies: 223
-- Data for Name: attribute_group; Type: TABLE DATA; Schema: public; Owner: admin
--



--
-- TOC entry 3474 (class 0 OID 347153)
-- Dependencies: 227
-- Data for Name: attribute_value; Type: TABLE DATA; Schema: public; Owner: admin
--



--
-- TOC entry 3462 (class 0 OID 346981)
-- Dependencies: 215
-- Data for Name: elements_group; Type: TABLE DATA; Schema: public; Owner: admin
--

INSERT INTO public.elements_group VALUES (0, 'Общая', NULL);
INSERT INTO public.elements_group VALUES (1, 'Оргтехника', 0);
INSERT INTO public.elements_group VALUES (2, 'Компьютеры', 0);
INSERT INTO public.elements_group VALUES (3, 'Мониторы', 0);
INSERT INTO public.elements_group VALUES (4, 'Компоненты', 0);
INSERT INTO public.elements_group VALUES (5, 'ИБП', 0);
INSERT INTO public.elements_group VALUES (6, 'Торговое оборудование', 0);
INSERT INTO public.elements_group VALUES (7, 'Расходные материалы', 0);


--
-- TOC entry 3463 (class 0 OID 346994)
-- Dependencies: 216
-- Data for Name: element_type; Type: TABLE DATA; Schema: public; Owner: admin
--

INSERT INTO public.element_type VALUES (0, 'Принтер лазерный', 1);
INSERT INTO public.element_type VALUES (1, 'МФУ', 1);
INSERT INTO public.element_type VALUES (2, 'Плоттер', 1);
INSERT INTO public.element_type VALUES (3, 'Принтер струйный', 1);
INSERT INTO public.element_type VALUES (4, 'Монитор', 3);
INSERT INTO public.element_type VALUES (5, 'Весы', 6);
INSERT INTO public.element_type VALUES (6, 'Горячий стол', 6);
INSERT INTO public.element_type VALUES (7, 'Запайщик', 6);
INSERT INTO public.element_type VALUES (8, 'Принтер штрихкодов', 1);
INSERT INTO public.element_type VALUES (9, 'Клавиатура торговая', 6);
INSERT INTO public.element_type VALUES (10, 'Электронный компонент', 4);
INSERT INTO public.element_type VALUES (11, 'Механический компонент', 4);
INSERT INTO public.element_type VALUES (12, 'Сложный компонент', 4);
INSERT INTO public.element_type VALUES (13, 'Электрический компонент', 4);
INSERT INTO public.element_type VALUES (14, 'Расходный материал', 7);
INSERT INTO public.element_type VALUES (15, 'Тонер-картридж', 1);


--
-- TOC entry 3464 (class 0 OID 347004)
-- Dependencies: 217
-- Data for Name: element; Type: TABLE DATA; Schema: public; Owner: admin
--

INSERT INTO public.element VALUES (1, 'Kyocera FS-2035', '', NULL, 0, 0);
INSERT INTO public.element VALUES (3, 'Kyocera FS-1030', '', NULL, 0, 0);
INSERT INTO public.element VALUES (4, 'Canon MF211', '', NULL, 0, 0);
INSERT INTO public.element VALUES (5, 'Ремкомплект', '', NULL, 1, 11);
INSERT INTO public.element VALUES (6, 'DRAM', '', NULL, 1, 11);
INSERT INTO public.element VALUES (7, 'MK', '', NULL, 1, 11);
INSERT INTO public.element VALUES (8, 'Фотовал', '', NULL, 2, 11);
INSERT INTO public.element VALUES (54, 'Canon MF4410', '', NULL, 0, 0);
INSERT INTO public.element VALUES (55, 'Магнитный вал', '', NULL, 2, 11);
INSERT INTO public.element VALUES (56, 'Картридж Canon/HP 737', '', NULL, 1, 11);
INSERT INTO public.element VALUES (57, 'Картридж Canon/HP 728', '', NULL, 1, 11);
INSERT INTO public.element VALUES (58, 'Картридж Kyocera TK-1110', 'Тонер-картридж Kyocera TK-1110 для FS-1040/1020MFP/1120MFP (1T02M50NX1)', NULL, 1, 11);
INSERT INTO public.element VALUES (59, 'Картридж Kyocera TK-1120', 'Тонер-картридж Kyocera TK-1120 для FS-1060DN/1025MFP/1125MFP (1T02M70NX1)', NULL, 1, 11);
INSERT INTO public.element VALUES (52, 'Картридж Kyocera TK-1140', 'Тонер-картридж Kyocera TK-1140 для FS-1035MFPDP/1135MFP, M2035dn/M2535dn (1T02ML0NLC)', NULL, 1, 11);
INSERT INTO public.element VALUES (60, 'Картридж Kyocera TK-1170', 'Тонер-картридж Kyocera TK-1170 для M2040dn/M2540dn/M2640idw (1T02S50NL0)', NULL, 1, 11);
INSERT INTO public.element VALUES (61, 'Картридж Kyocera TK-3100', 'Тонер-картридж Kyocera TK-3100 для FS-2100D/2100DN/4100DN/4200DN/4300DN, M3040dn/M3540dn (1T02MS0NL0)', NULL, 1, 11);
INSERT INTO public.element VALUES (62, 'Картридж Kyocera TK-350', 'Тонер-картридж Kyocera TK-350 для FS-3920DN/3040/3140MFP/3040MFP /3140MFP /3540MFP/3640MFP (1T02LX0NLC)', NULL, 1, 11);
INSERT INTO public.element VALUES (63, 'Картридж Kyocera TK-160', 'Тонер-картридж Kyocera TK-160 для FS-1120D/DN, P2035D/DN (1T02LY0NLC, 1T02LY0NL0)', NULL, 1, 11);
INSERT INTO public.element VALUES (64, 'Картридж Kyocera TK-1200', 'Картридж TK-1200 для P2335d/P2335dn/P2335dw/ M2235dn/M2735dn/M2835dw (1T02VP0RU0)', NULL, 1, 11);
INSERT INTO public.element VALUES (65, 'Картридж Kyocera TK-3160', 'Тонер-картридж Kyocera TK-3160 для P3045dn/P3050dn/P3055dn/P3060dn/P3155dn/M3145dn/M3645dn/P3145dn/P3150dn (1T02T90NL1)', NULL, 1, 11);
INSERT INTO public.element VALUES (66, 'Картридж Canon/HP CE285A', '', NULL, 1, 11);
INSERT INTO public.element VALUES (68, 'Kyocera P2040dn', 'Принтер Kyocera ECOSYS P2040dn (1102RX3NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (69, 'Kyocera P2040dw', 'Принтер Kyocera ECOSYS P2040dw (1102RY3NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (70, 'Kyocera FS-1040', 'Принтер Kyocera FS-1040 (1102M23RU2)', NULL, 0, 0);
INSERT INTO public.element VALUES (71, 'Kyocera FS-1020MFP', 'МФУ Kyocera FS-1020MFP (1102M43RUV, 1102M43RU2)', NULL, 0, 0);
INSERT INTO public.element VALUES (72, 'Kyocera FS-1120MFP', 'МФУ Kyocera FS-1120MFP (1102M53RU2)', NULL, 0, 0);
INSERT INTO public.element VALUES (73, 'Kyocera FS-1060dn', 'Принтер Kyocera FS-1060DN (1102M33RU2)', NULL, 0, 0);
INSERT INTO public.element VALUES (74, 'Kyocera FS-1025MFP', 'МФУ Kyocera FS-1025MFP (1102M63RU2)', NULL, 0, 0);
INSERT INTO public.element VALUES (75, 'Kyocera FS-1125', 'МФУ Kyocera FS-1125MFP (1102M73RU2)', NULL, 0, 0);
INSERT INTO public.element VALUES (76, 'Kyocera FS-1035MFP/DP', '', NULL, 0, 0);
INSERT INTO public.element VALUES (77, 'Kyocera FS-1135MFP', '', NULL, 0, 0);
INSERT INTO public.element VALUES (82, 'Картридж TK-1160', 'Тонер-картридж Kyocera TK-1160 для P2040dn/P2040dw (1T02RY0NL0)', NULL, 1, 11);
INSERT INTO public.element VALUES (90, 'Kyocera FS-3920DN', '', NULL, 0, 0);
INSERT INTO public.element VALUES (91, 'Kyocera FS-3040MFP+', '', NULL, 0, 0);
INSERT INTO public.element VALUES (92, 'Kyocera FS-3140MFP+', '', NULL, 0, 0);
INSERT INTO public.element VALUES (93, 'Kyocera FS-3040', '', NULL, 0, 0);
INSERT INTO public.element VALUES (94, 'Kyocera FS-3540MFP', '', NULL, 0, 0);
INSERT INTO public.element VALUES (95, 'Kyocera FS-3640MFP', '', NULL, 0, 0);
INSERT INTO public.element VALUES (96, 'Kyocera FS-1120D/DN', '', NULL, 0, 0);
INSERT INTO public.element VALUES (97, 'Kyocera Ecosys P2035d/dn', '', NULL, 0, 0);
INSERT INTO public.element VALUES (98, 'Kyocera ECOSYS P2335d/dn/dw', 'Принтер Kyocera ECOSYS P2335dn (1102VB3RU0)', NULL, 0, 0);
INSERT INTO public.element VALUES (102, 'Kyocera ECOSYS P3045dn', 'Принтер Kyocera ECOSYS P3045dn (1102T93NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (103, 'Kyocera ECOSYS P3050dn', 'Принтер Kyocera ECOSYS P3050dn (1102T83NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (104, 'Kyocera ECOSYS P3055dn', 'Принтер Kyocera ECOSYS P3055dn (1102T73NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (105, 'Kyocera ECOSYS P3060dn', 'Принтер Kyocera ECOSYS P3060dn (1102T63NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (106, 'Kyocera ECOSYS P3155dn', 'Принтер Kyocera ECOSYS P3155dn (1102TR3NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (109, 'Kyocera ECOSYS P3145dn', 'Принтер Kyocera ECOSYS P3145dn (1102TT3NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (110, 'Kyocera ECOSYS P3150dn', 'Принтер Kyocera ECOSYS P3150dn (1102TS3NL0)', NULL, 0, 0);
INSERT INTO public.element VALUES (202, 'Панель управления горячим столом', '', NULL, 1, 11);
INSERT INTO public.element VALUES (203, 'Нагревательный элемент для горячего стола', '', NULL, 2, 11);
INSERT INTO public.element VALUES (204, 'Переключатель для горячего стола', '', NULL, 2, 11);
INSERT INTO public.element VALUES (253, 'Kyocera Ecosys FS-4100/FS-4200/FS-4300', '', NULL, 0, 0);
INSERT INTO public.element VALUES (252, 'Kyocera Ecosys FS-2100', '', NULL, 0, 0);
INSERT INTO public.element VALUES (78, 'Kyocera ECOSYS M2035/M2535', '', NULL, 0, 1);
INSERT INTO public.element VALUES (99, 'Kyocera ECOSYS M2235/M2735/M2835', 'МФУ Kyocera ECOSYS M2235dn (1102VS3RU0), МФУ Kyocera ECOSYS M2735dn (1102VT3RU0)', NULL, 0, 1);
INSERT INTO public.element VALUES (257, 'Узел термозакрепления (печь)', '', NULL, 1, 11);
INSERT INTO public.element VALUES (254, 'Kyocera Ecosys M3145/ M3645', '', NULL, 0, 1);
INSERT INTO public.element VALUES (255, 'Kyocera Ecosys M3040/M3540', '', NULL, 0, 1);
INSERT INTO public.element VALUES (67, 'Kyocera M2040dn', 'МФУ Kyocera ECOSYS M2040dn (1102S33NL0)', NULL, 0, 1);
INSERT INTO public.element VALUES (79, 'Kyocera ECOSYS M2030/M2530', '', NULL, 0, 1);
INSERT INTO public.element VALUES (256, 'Картридж Kyocera TK-1130', 'Тонер-картридж Kyocera TK-1130 для FS-1030MFP/ FS-1030MFP/DP/ FS-1130MFP/ M2030dn PN/ M2030dn/ M2530dn', NULL, 1, 11);
INSERT INTO public.element VALUES (80, 'Kyocera ECOSYS M2540/ M2640', 'МФУ Kyocera ECOSYS M2540dn (1102SH3NL0) / МФУ Kyocera ECOSYS M2640idw (1102S53NL0)', NULL, 0, 1);
INSERT INTO public.element VALUES (153, 'Горячий стол CAS', 'Горячий стол служит для оперативной  и надежной упаковки пищевых продуктов в пленку ПВХ.', NULL, 0, 6);


--
-- TOC entry 3465 (class 0 OID 347024)
-- Dependencies: 218
-- Data for Name: element_groups; Type: TABLE DATA; Schema: public; Owner: admin
--

INSERT INTO public.element_groups VALUES (1, 1);
INSERT INTO public.element_groups VALUES (3, 1);
INSERT INTO public.element_groups VALUES (4, 1);
INSERT INTO public.element_groups VALUES (5, 4);
INSERT INTO public.element_groups VALUES (6, 4);
INSERT INTO public.element_groups VALUES (7, 4);
INSERT INTO public.element_groups VALUES (8, 4);
INSERT INTO public.element_groups VALUES (54, 1);
INSERT INTO public.element_groups VALUES (55, 4);
INSERT INTO public.element_groups VALUES (56, 4);
INSERT INTO public.element_groups VALUES (57, 4);
INSERT INTO public.element_groups VALUES (58, 4);
INSERT INTO public.element_groups VALUES (59, 4);
INSERT INTO public.element_groups VALUES (60, 4);
INSERT INTO public.element_groups VALUES (61, 4);
INSERT INTO public.element_groups VALUES (63, 4);
INSERT INTO public.element_groups VALUES (62, 4);
INSERT INTO public.element_groups VALUES (64, 4);
INSERT INTO public.element_groups VALUES (65, 4);
INSERT INTO public.element_groups VALUES (66, 4);
INSERT INTO public.element_groups VALUES (67, 1);
INSERT INTO public.element_groups VALUES (68, 1);
INSERT INTO public.element_groups VALUES (69, 1);
INSERT INTO public.element_groups VALUES (70, 1);
INSERT INTO public.element_groups VALUES (71, 1);
INSERT INTO public.element_groups VALUES (72, 1);
INSERT INTO public.element_groups VALUES (73, 1);
INSERT INTO public.element_groups VALUES (74, 1);
INSERT INTO public.element_groups VALUES (75, 1);
INSERT INTO public.element_groups VALUES (76, 1);
INSERT INTO public.element_groups VALUES (77, 1);
INSERT INTO public.element_groups VALUES (78, 1);
INSERT INTO public.element_groups VALUES (79, 1);
INSERT INTO public.element_groups VALUES (80, 1);
INSERT INTO public.element_groups VALUES (82, 4);
INSERT INTO public.element_groups VALUES (90, 1);
INSERT INTO public.element_groups VALUES (91, 1);
INSERT INTO public.element_groups VALUES (92, 1);
INSERT INTO public.element_groups VALUES (93, 1);
INSERT INTO public.element_groups VALUES (94, 1);
INSERT INTO public.element_groups VALUES (95, 1);
INSERT INTO public.element_groups VALUES (96, 1);
INSERT INTO public.element_groups VALUES (97, 1);
INSERT INTO public.element_groups VALUES (98, 1);
INSERT INTO public.element_groups VALUES (99, 1);
INSERT INTO public.element_groups VALUES (102, 1);
INSERT INTO public.element_groups VALUES (103, 1);
INSERT INTO public.element_groups VALUES (104, 1);
INSERT INTO public.element_groups VALUES (105, 1);
INSERT INTO public.element_groups VALUES (106, 1);
INSERT INTO public.element_groups VALUES (109, 1);
INSERT INTO public.element_groups VALUES (110, 1);
INSERT INTO public.element_groups VALUES (153, 6);
INSERT INTO public.element_groups VALUES (202, 4);
INSERT INTO public.element_groups VALUES (203, 4);
INSERT INTO public.element_groups VALUES (204, 4);
INSERT INTO public.element_groups VALUES (252, 1);
INSERT INTO public.element_groups VALUES (253, 1);
INSERT INTO public.element_groups VALUES (254, 1);
INSERT INTO public.element_groups VALUES (255, 1);
INSERT INTO public.element_groups VALUES (52, 4);
INSERT INTO public.element_groups VALUES (256, 4);
INSERT INTO public.element_groups VALUES (257, 4);


--
-- TOC entry 3466 (class 0 OID 347043)
-- Dependencies: 219
-- Data for Name: proxy; Type: TABLE DATA; Schema: public; Owner: admin
--

INSERT INTO public.proxy VALUES (60, 'TK-1160', NULL, 0, NULL, 15);
INSERT INTO public.proxy VALUES (54, '737', NULL, 0, 56, 15);
INSERT INTO public.proxy VALUES (253, '728', NULL, 0, 57, 15);
INSERT INTO public.proxy VALUES (152, 'MF211', NULL, 0, 4, 1);
INSERT INTO public.proxy VALUES (2, '2MK93010 DV-1140(E)', NULL, 1, NULL, 11);
INSERT INTO public.proxy VALUES (154, 'FS-2100D', NULL, 0, 252, 0);
INSERT INTO public.proxy VALUES (153, 'MF4410', NULL, 0, 54, 1);
INSERT INTO public.proxy VALUES (3, '2LZ93061 DK-170', NULL, 1, 6, 11);
INSERT INTO public.proxy VALUES (202, 'CAS CNW-460', NULL, 0, 153, 6);
INSERT INTO public.proxy VALUES (55, 'CE285A', NULL, 0, 66, 15);
INSERT INTO public.proxy VALUES (155, 'FS-2100DN', NULL, 0, 252, 0);
INSERT INTO public.proxy VALUES (156, 'FS-4100DN', NULL, 0, 253, 0);
INSERT INTO public.proxy VALUES (157, 'FS-4200dn', NULL, 0, 253, 0);
INSERT INTO public.proxy VALUES (158, 'FS-4300dn', NULL, 0, 253, 0);
INSERT INTO public.proxy VALUES (57, 'HP LJ 1005 -- магнитный вал', NULL, 2, 55, 11);
INSERT INTO public.proxy VALUES (56, 'HP LJ 1010 -- магнитный вал', NULL, 2, 55, 11);
INSERT INTO public.proxy VALUES (164, 'M2030dn', NULL, 0, 79, 1);
INSERT INTO public.proxy VALUES (160, 'M2035dn', NULL, 0, 78, 1);
INSERT INTO public.proxy VALUES (161, 'M2235dn', NULL, 0, 99, 1);
INSERT INTO public.proxy VALUES (165, 'M2530dn', NULL, 0, 79, 1);
INSERT INTO public.proxy VALUES (159, 'M2535dn', NULL, 0, 78, 1);
INSERT INTO public.proxy VALUES (168, 'M2540dn', NULL, 0, 80, 1);
INSERT INTO public.proxy VALUES (167, 'M2640idw', NULL, 0, 80, 1);
INSERT INTO public.proxy VALUES (162, 'M2735dn', NULL, 0, 99, 1);
INSERT INTO public.proxy VALUES (163, 'M2835dn', NULL, 0, 99, 1);
INSERT INTO public.proxy VALUES (169, 'M3040dn', NULL, 0, 255, 1);
INSERT INTO public.proxy VALUES (171, 'M3145dn', NULL, 0, 254, 1);
INSERT INTO public.proxy VALUES (172, 'M3145idn', NULL, 0, 254, 1);
INSERT INTO public.proxy VALUES (170, 'M3540dn', NULL, 0, 255, 1);
INSERT INTO public.proxy VALUES (173, 'M3645dn', NULL, 0, 254, 1);
INSERT INTO public.proxy VALUES (174, 'M3645idn', NULL, 0, 254, 1);
INSERT INTO public.proxy VALUES (4, 'MK - ремкомплект', NULL, 1, 7, 11);
INSERT INTO public.proxy VALUES (52, 'TK-1110', NULL, 0, 58, 15);
INSERT INTO public.proxy VALUES (58, 'TK-1120', NULL, 0, 59, 15);
INSERT INTO public.proxy VALUES (166, 'TK-1130', NULL, 0, 256, 15);
INSERT INTO public.proxy VALUES (59, 'TK-1170', NULL, 0, 60, 15);
INSERT INTO public.proxy VALUES (64, 'TK-1200', NULL, 0, 64, 15);
INSERT INTO public.proxy VALUES (63, 'TK-160', NULL, 0, 63, 15);
INSERT INTO public.proxy VALUES (61, 'TK-3100', NULL, 0, 61, 15);
INSERT INTO public.proxy VALUES (65, 'TK-3160', NULL, 0, 65, 15);
INSERT INTO public.proxy VALUES (62, 'TK-350', NULL, 0, 62, 15);
INSERT INTO public.proxy VALUES (1, 'Барабан для Kyocera Ecosys M2035DN, M2535DN, P2035 для DK-170, DK-150, DK-110, DK-130 (без опорной втулки)', 'Барабан для Kyocera Ecosys M2035DN, M2535DN, P2035 для DK-170, DK-150, DK-110, DK-130 (без опорной втулки)', 2, 8, 11);
INSERT INTO public.proxy VALUES (104, 'Выключатель для горячего стола CAS CNW', NULL, 2, 204, 11);
INSERT INTO public.proxy VALUES (105, 'Кулисный переключатель KCD3', NULL, 2, 204, 11);
INSERT INTO public.proxy VALUES (103, 'Нагревательный элемент к CAS CNW-460', NULL, 2, 203, 11);
INSERT INTO public.proxy VALUES (102, 'Панель управления CAS CNW-460', NULL, 1, 202, 11);
INSERT INTO public.proxy VALUES (53, 'ТК-1140', NULL, 0, 52, 15);


--
-- TOC entry 3468 (class 0 OID 347082)
-- Dependencies: 221
-- Data for Name: element_proxy; Type: TABLE DATA; Schema: public; Owner: admin
--

INSERT INTO public.element_proxy VALUES (5, 4);
INSERT INTO public.element_proxy VALUES (7, 2);
INSERT INTO public.element_proxy VALUES (8, 1);
INSERT INTO public.element_proxy VALUES (6, 3);
INSERT INTO public.element_proxy VALUES (52, 52);
INSERT INTO public.element_proxy VALUES (52, 53);
INSERT INTO public.element_proxy VALUES (52, 54);
INSERT INTO public.element_proxy VALUES (52, 55);
INSERT INTO public.element_proxy VALUES (55, 56);
INSERT INTO public.element_proxy VALUES (55, 57);
INSERT INTO public.element_proxy VALUES (58, 52);
INSERT INTO public.element_proxy VALUES (59, 58);
INSERT INTO public.element_proxy VALUES (60, 59);
INSERT INTO public.element_proxy VALUES (82, 60);
INSERT INTO public.element_proxy VALUES (61, 61);
INSERT INTO public.element_proxy VALUES (62, 62);
INSERT INTO public.element_proxy VALUES (63, 63);
INSERT INTO public.element_proxy VALUES (64, 64);
INSERT INTO public.element_proxy VALUES (65, 65);
INSERT INTO public.element_proxy VALUES (202, 102);
INSERT INTO public.element_proxy VALUES (203, 103);
INSERT INTO public.element_proxy VALUES (204, 105);
INSERT INTO public.element_proxy VALUES (204, 104);
INSERT INTO public.element_proxy VALUES (4, 152);
INSERT INTO public.element_proxy VALUES (56, 54);
INSERT INTO public.element_proxy VALUES (54, 153);
INSERT INTO public.element_proxy VALUES (57, 253);
INSERT INTO public.element_proxy VALUES (252, 154);


--
-- TOC entry 3467 (class 0 OID 347060)
-- Dependencies: 220
-- Data for Name: elements_composite; Type: TABLE DATA; Schema: public; Owner: admin
--

INSERT INTO public.elements_composite VALUES (1, 5, 1, 4);
INSERT INTO public.elements_composite VALUES (2, 5, 3, 4);
INSERT INTO public.elements_composite VALUES (4, 7, 5, 2);
INSERT INTO public.elements_composite VALUES (52, 6, 5, 3);
INSERT INTO public.elements_composite VALUES (53, 8, 6, 1);
INSERT INTO public.elements_composite VALUES (54, 52, 1, 53);
INSERT INTO public.elements_composite VALUES (57, 58, 70, 52);
INSERT INTO public.elements_composite VALUES (58, 58, 71, 52);
INSERT INTO public.elements_composite VALUES (59, 58, 72, 52);
INSERT INTO public.elements_composite VALUES (60, 59, 73, 58);
INSERT INTO public.elements_composite VALUES (61, 59, 74, 58);
INSERT INTO public.elements_composite VALUES (62, 59, 75, 58);
INSERT INTO public.elements_composite VALUES (63, 52, 76, 53);
INSERT INTO public.elements_composite VALUES (64, 52, 77, 53);
INSERT INTO public.elements_composite VALUES (65, 52, 78, 53);
INSERT INTO public.elements_composite VALUES (67, 60, 67, 59);
INSERT INTO public.elements_composite VALUES (68, 60, 80, 59);
INSERT INTO public.elements_composite VALUES (70, 82, 68, 60);
INSERT INTO public.elements_composite VALUES (71, 82, 69, 60);
INSERT INTO public.elements_composite VALUES (79, 62, 90, 62);
INSERT INTO public.elements_composite VALUES (80, 62, 91, 62);
INSERT INTO public.elements_composite VALUES (81, 62, 93, 62);
INSERT INTO public.elements_composite VALUES (82, 62, 92, 62);
INSERT INTO public.elements_composite VALUES (83, 62, 94, 62);
INSERT INTO public.elements_composite VALUES (84, 62, 95, 62);
INSERT INTO public.elements_composite VALUES (85, 63, 96, 63);
INSERT INTO public.elements_composite VALUES (86, 63, 97, 63);
INSERT INTO public.elements_composite VALUES (87, 64, 98, 64);
INSERT INTO public.elements_composite VALUES (88, 64, 99, 64);
INSERT INTO public.elements_composite VALUES (91, 65, 102, 65);
INSERT INTO public.elements_composite VALUES (92, 65, 103, 65);
INSERT INTO public.elements_composite VALUES (93, 65, 104, 65);
INSERT INTO public.elements_composite VALUES (94, 65, 105, 65);
INSERT INTO public.elements_composite VALUES (95, 65, 106, 65);
INSERT INTO public.elements_composite VALUES (98, 65, 109, 65);
INSERT INTO public.elements_composite VALUES (99, 65, 110, 65);
INSERT INTO public.elements_composite VALUES (103, 202, 153, 102);
INSERT INTO public.elements_composite VALUES (104, 203, 202, 103);
INSERT INTO public.elements_composite VALUES (105, 204, 202, 104);
INSERT INTO public.elements_composite VALUES (106, 204, 202, 105);
INSERT INTO public.elements_composite VALUES (152, 61, 253, 61);
INSERT INTO public.elements_composite VALUES (153, 61, 252, 61);
INSERT INTO public.elements_composite VALUES (154, 61, 255, 61);
INSERT INTO public.elements_composite VALUES (155, 256, 79, 166);
INSERT INTO public.elements_composite VALUES (156, 65, 254, 65);
INSERT INTO public.elements_composite VALUES (202, 56, 4, 54);
INSERT INTO public.elements_composite VALUES (203, 57, 54, 253);


--
-- TOC entry 3476 (class 0 OID 347178)
-- Dependencies: 229
-- Data for Name: unit; Type: TABLE DATA; Schema: public; Owner: admin
--



--
-- TOC entry 3475 (class 0 OID 347168)
-- Dependencies: 228
-- Data for Name: unit_dic; Type: TABLE DATA; Schema: public; Owner: admin
--



--
-- TOC entry 3493 (class 0 OID 0)
-- Dependencies: 240
-- Name: attr_dic_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.attr_dic_seq', 1, false);


--
-- TOC entry 3494 (class 0 OID 0)
-- Dependencies: 239
-- Name: attr_group_dic_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.attr_group_dic_seq', 1, false);


--
-- TOC entry 3495 (class 0 OID 0)
-- Dependencies: 241
-- Name: attr_value_dic_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.attr_value_dic_seq', 1, false);


--
-- TOC entry 3496 (class 0 OID 0)
-- Dependencies: 232
-- Name: attribute_group_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.attribute_group_seq', 1, false);


--
-- TOC entry 3497 (class 0 OID 0)
-- Dependencies: 231
-- Name: attribute_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.attribute_seq', 51, true);


--
-- TOC entry 3498 (class 0 OID 0)
-- Dependencies: 233
-- Name: element_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.element_seq', 301, true);


--
-- TOC entry 3499 (class 0 OID 0)
-- Dependencies: 234
-- Name: element_type_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.element_type_seq', 14, true);


--
-- TOC entry 3500 (class 0 OID 0)
-- Dependencies: 235
-- Name: elements_composite_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.elements_composite_seq', 251, true);


--
-- TOC entry 3501 (class 0 OID 0)
-- Dependencies: 236
-- Name: elements_group_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.elements_group_seq', 35, false);


--
-- TOC entry 3502 (class 0 OID 0)
-- Dependencies: 237
-- Name: proxy_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.proxy_seq', 301, true);


--
-- TOC entry 3503 (class 0 OID 0)
-- Dependencies: 238
-- Name: unit_dic_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.unit_dic_seq', 1, false);

