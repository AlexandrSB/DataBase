--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2024-03-11 08:33:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3471 (class 0 OID 355310)
-- Dependencies: 224
-- Data for Name: attr_dic; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.attr_dic (id, name, attr_group_dic_id) FROM stdin;
\.


--
-- TOC entry 3469 (class 0 OID 355289)
-- Dependencies: 222
-- Data for Name: attr_group_dic; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.attr_group_dic (id, name) FROM stdin;
1	Общие характеристики
2	Технические характеристики
\.


--
-- TOC entry 3473 (class 0 OID 355335)
-- Dependencies: 226
-- Data for Name: attr_value_dic; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.attr_value_dic (id, name, attr_dic_id) FROM stdin;
\.


--
-- TOC entry 3472 (class 0 OID 355320)
-- Dependencies: 225
-- Data for Name: attribute; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.attribute (id, attr_dic_id, attr_group_id) FROM stdin;
\.


--
-- TOC entry 3470 (class 0 OID 355294)
-- Dependencies: 223
-- Data for Name: attribute_group; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.attribute_group (id, attr_group_dic_id, proxy_id) FROM stdin;
1	1	154
\.


--
-- TOC entry 3474 (class 0 OID 355345)
-- Dependencies: 227
-- Data for Name: attribute_value; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.attribute_value (id, attr_value_dic_id) FROM stdin;
\.


--
-- TOC entry 3464 (class 0 OID 355196)
-- Dependencies: 217
-- Data for Name: element; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.element (id, name, description, parent_id, category, element_type_id) FROM stdin;
1	Kyocera FS-2035		\N	0	0
3	Kyocera FS-1030		\N	0	0
5	Ремкомплект		\N	1	11
6	DRAM		\N	1	11
7	MK		\N	1	11
56	Картридж Canon/HP 737		\N	1	11
57	Картридж Canon/HP 728		\N	1	11
58	Картридж Kyocera TK-1110	Тонер-картридж Kyocera TK-1110 для FS-1040/1020MFP/1120MFP (1T02M50NX1)	\N	1	11
59	Картридж Kyocera TK-1120	Тонер-картридж Kyocera TK-1120 для FS-1060DN/1025MFP/1125MFP (1T02M70NX1)	\N	1	11
52	Картридж Kyocera TK-1140	Тонер-картридж Kyocera TK-1140 для FS-1035MFPDP/1135MFP, M2035dn/M2535dn (1T02ML0NLC)	\N	1	11
60	Картридж Kyocera TK-1170	Тонер-картридж Kyocera TK-1170 для M2040dn/M2540dn/M2640idw (1T02S50NL0)	\N	1	11
61	Картридж Kyocera TK-3100	Тонер-картридж Kyocera TK-3100 для FS-2100D/2100DN/4100DN/4200DN/4300DN, M3040dn/M3540dn (1T02MS0NL0)	\N	1	11
62	Картридж Kyocera TK-350	Тонер-картридж Kyocera TK-350 для FS-3920DN/3040/3140MFP/3040MFP /3140MFP /3540MFP/3640MFP (1T02LX0NLC)	\N	1	11
63	Картридж Kyocera TK-160	Тонер-картридж Kyocera TK-160 для FS-1120D/DN, P2035D/DN (1T02LY0NLC, 1T02LY0NL0)	\N	1	11
64	Картридж Kyocera TK-1200	Картридж TK-1200 для P2335d/P2335dn/P2335dw/ M2235dn/M2735dn/M2835dw (1T02VP0RU0)	\N	1	11
65	Картридж Kyocera TK-3160	Тонер-картридж Kyocera TK-3160 для P3045dn/P3050dn/P3055dn/P3060dn/P3155dn/M3145dn/M3645dn/P3145dn/P3150dn (1T02T90NL1)	\N	1	11
66	Картридж Canon/HP CE285A		\N	1	11
68	Kyocera P2040dn	Принтер Kyocera ECOSYS P2040dn (1102RX3NL0)	\N	0	0
69	Kyocera P2040dw	Принтер Kyocera ECOSYS P2040dw (1102RY3NL0)	\N	0	0
70	Kyocera FS-1040	Принтер Kyocera FS-1040 (1102M23RU2)	\N	0	0
71	Kyocera FS-1020MFP	МФУ Kyocera FS-1020MFP (1102M43RUV, 1102M43RU2)	\N	0	0
72	Kyocera FS-1120MFP	МФУ Kyocera FS-1120MFP (1102M53RU2)	\N	0	0
73	Kyocera FS-1060dn	Принтер Kyocera FS-1060DN (1102M33RU2)	\N	0	0
74	Kyocera FS-1025MFP	МФУ Kyocera FS-1025MFP (1102M63RU2)	\N	0	0
75	Kyocera FS-1125	МФУ Kyocera FS-1125MFP (1102M73RU2)	\N	0	0
76	Kyocera FS-1035MFP/DP		\N	0	0
77	Kyocera FS-1135MFP		\N	0	0
90	Kyocera FS-3920DN		\N	0	0
91	Kyocera FS-3040MFP+		\N	0	0
92	Kyocera FS-3140MFP+		\N	0	0
93	Kyocera FS-3040		\N	0	0
94	Kyocera FS-3540MFP		\N	0	0
95	Kyocera FS-3640MFP		\N	0	0
96	Kyocera FS-1120D/DN		\N	0	0
97	Kyocera Ecosys P2035d/dn		\N	0	0
98	Kyocera ECOSYS P2335d/dn/dw	Принтер Kyocera ECOSYS P2335dn (1102VB3RU0)	\N	0	0
102	Kyocera ECOSYS P3045dn	Принтер Kyocera ECOSYS P3045dn (1102T93NL0)	\N	0	0
103	Kyocera ECOSYS P3050dn	Принтер Kyocera ECOSYS P3050dn (1102T83NL0)	\N	0	0
104	Kyocera ECOSYS P3055dn	Принтер Kyocera ECOSYS P3055dn (1102T73NL0)	\N	0	0
105	Kyocera ECOSYS P3060dn	Принтер Kyocera ECOSYS P3060dn (1102T63NL0)	\N	0	0
106	Kyocera ECOSYS P3155dn	Принтер Kyocera ECOSYS P3155dn (1102TR3NL0)	\N	0	0
109	Kyocera ECOSYS P3145dn	Принтер Kyocera ECOSYS P3145dn (1102TT3NL0)	\N	0	0
110	Kyocera ECOSYS P3150dn	Принтер Kyocera ECOSYS P3150dn (1102TS3NL0)	\N	0	0
202	Панель управления горячим столом		\N	1	11
203	Нагревательный элемент для горячего стола		\N	2	11
204	Переключатель для горячего стола		\N	2	11
253	Kyocera Ecosys FS-4100/FS-4200/FS-4300		\N	0	0
252	Kyocera Ecosys FS-2100		\N	0	0
78	Kyocera ECOSYS M2035/M2535		\N	0	1
99	Kyocera ECOSYS M2235/M2735/M2835	МФУ Kyocera ECOSYS M2235dn (1102VS3RU0), МФУ Kyocera ECOSYS M2735dn (1102VT3RU0)	\N	0	1
257	Узел термозакрепления (печь)		\N	1	11
254	Kyocera Ecosys M3145/ M3645		\N	0	1
255	Kyocera Ecosys M3040/M3540		\N	0	1
67	Kyocera M2040dn	МФУ Kyocera ECOSYS M2040dn (1102S33NL0)	\N	0	1
79	Kyocera ECOSYS M2030/M2530		\N	0	1
256	Картридж Kyocera TK-1130	Тонер-картридж Kyocera TK-1130 для FS-1030MFP/ FS-1030MFP/DP/ FS-1130MFP/ M2030dn PN/ M2030dn/ M2530dn	\N	1	11
80	Kyocera ECOSYS M2540/ M2640	МФУ Kyocera ECOSYS M2540dn (1102SH3NL0) / МФУ Kyocera ECOSYS M2640idw (1102S53NL0)	\N	0	1
153	Горячий стол CAS	Горячий стол служит для оперативной  и надежной упаковки пищевых продуктов в пленку ПВХ.	\N	0	6
302	Тонер для принтеров Kyocera (монохромная печать)		\N	3	14
303	Тонер для принтеров Canon/HP (монохромная печать)		\N	3	14
82	Картридж Kyocera TK-1160	Тонер-картридж Kyocera TK-1160 для P2040dn/P2040dw (1T02RY0NL0)	\N	1	11
352	Узел захвата бумаги с нижнего лотка		\N	1	11
353	Блок лазера		\N	1	11
354	Ролик захвата бумаги (Canon/HP)		\N	2	11
402	Термопленка		\N	2	11
403	Термоэлемент (Тэн) для лазерных принтеров		\N	2	11
404	Блок лазера для принтера Canon/HP		\N	2	11
54	Canon MF4410		\N	0	1
4	Canon MF211	МФУ Canon MF211	\N	0	1
55	Магнитный вал для картриджей Canon/HP 1005, 1505		\N	2	11
452	Upper для картриджей HP/Canon		\N	1	11
502	Lower для картриджей HP/Canon		\N	1	11
8	Фотовал		\N	2	11
503	Бункер отработанного тонера для картриджей HP/Canon		\N	2	11
553	Ракель		\N	2	11
554	Вал заряда (коротрон)		\N	2	11
602	Магнитный вал для принтеров Canon/HP 1010		\N	2	11
552	Дозирующее лезвие (Doctor Blade) для картриджей Canon/HP 1005, 1505		\N	2	11
603	Дозирующее лезвие (Doctor Blade) для картриджей Canon/HP 1010		\N	2	11
\.


--
-- TOC entry 3465 (class 0 OID 355216)
-- Dependencies: 218
-- Data for Name: element_groups; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.element_groups (element_id, group_id) FROM stdin;
1	1
3	1
4	1
5	4
6	4
7	4
8	4
54	1
55	4
56	4
57	4
58	4
59	4
60	4
61	4
63	4
62	4
64	4
65	4
66	4
67	1
68	1
69	1
70	1
71	1
72	1
73	1
74	1
75	1
76	1
77	1
78	1
79	1
80	1
82	4
90	1
91	1
92	1
93	1
94	1
95	1
96	1
97	1
98	1
99	1
102	1
103	1
104	1
105	1
106	1
109	1
110	1
153	6
202	4
203	4
204	4
252	1
253	1
254	1
255	1
52	4
256	4
257	4
302	7
303	7
352	4
353	4
354	4
402	4
403	4
404	4
452	4
502	4
503	4
552	4
553	4
554	4
602	4
603	4
\.


--
-- TOC entry 3468 (class 0 OID 355274)
-- Dependencies: 221
-- Data for Name: element_proxy; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.element_proxy (element_id, proxy_id) FROM stdin;
5	4
7	2
8	1
6	3
52	52
52	53
52	54
52	55
55	57
58	52
59	58
60	59
82	60
61	61
62	62
63	63
64	64
65	65
202	102
203	103
204	105
204	104
4	152
56	54
54	153
57	253
252	154
1	160
6	302
7	303
302	352
303	354
256	166
303	402
257	452
352	453
353	454
354	453
354	455
402	502
403	503
404	504
452	552
502	553
503	554
8	602
553	652
552	653
554	654
602	56
603	702
\.


--
-- TOC entry 3463 (class 0 OID 355186)
-- Dependencies: 216
-- Data for Name: element_type; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.element_type (id, type, group_id) FROM stdin;
0	Принтер лазерный	1
1	МФУ	1
2	Плоттер	1
3	Принтер струйный	1
4	Монитор	3
5	Весы	6
6	Горячий стол	6
7	Запайщик	6
8	Принтер штрихкодов	1
9	Клавиатура торговая	6
10	Электронный компонент	4
11	Механический компонент	4
12	Сложный компонент	4
13	Электрический компонент	4
14	Расходный материал	7
15	Тонер-картридж	1
\.


--
-- TOC entry 3467 (class 0 OID 355252)
-- Dependencies: 220
-- Data for Name: elements_composite; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.elements_composite (id, element_source, element_destination, proxy_id) FROM stdin;
1	5	1	4
2	5	3	4
4	7	5	2
52	6	5	3
53	8	6	1
54	52	1	53
57	58	70	52
58	58	71	52
59	58	72	52
60	59	73	58
61	59	74	58
62	59	75	58
63	52	76	53
64	52	77	53
65	52	78	53
67	60	67	59
68	60	80	59
70	82	68	60
71	82	69	60
79	62	90	62
80	62	91	62
81	62	93	62
82	62	92	62
83	62	94	62
84	62	95	62
85	63	96	63
86	63	97	63
87	64	98	64
88	64	99	64
91	65	102	65
92	65	103	65
93	65	104	65
94	65	105	65
95	65	106	65
98	65	109	65
99	65	110	65
103	202	153	102
104	203	202	103
105	204	202	104
106	204	202	105
152	61	253	61
153	61	252	61
154	61	255	61
155	256	79	166
156	65	254	65
202	56	4	54
203	57	54	253
252	6	79	302
253	7	79	303
402	257	4	452
403	257	54	452
404	352	4	453
405	353	4	454
406	353	54	454
407	354	352	453
452	402	257	502
453	403	257	503
454	404	353	504
502	6	97	3
503	6	78	3
552	452	56	552
602	452	57	552
603	502	56	553
604	502	57	553
606	8	452	602
652	553	452	652
654	554	452	654
655	552	502	653
656	55	502	57
657	303	502	354
702	602	502	56
703	603	502	702
\.


--
-- TOC entry 3462 (class 0 OID 355173)
-- Dependencies: 215
-- Data for Name: elements_group; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.elements_group (id, name, parent_id) FROM stdin;
0	Общая	\N
1	Оргтехника	0
2	Компьютеры	0
3	Мониторы	0
4	Компоненты	0
5	ИБП	0
6	Торговое оборудование	0
7	Расходные материалы	0
\.


--
-- TOC entry 3461 (class 0 OID 355164)
-- Dependencies: 214
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1	InitDB Equipment	SQL	V1__InitDB_Equipment.sql	-532612413	admin	2024-02-16 16:30:45.075271	154	t
2	2	InitDB Sequences	SQL	V2__InitDB_Sequences.sql	1581538104	admin	2024-02-16 16:30:45.267284	14	t
3	3	FillDB	SQL	V3__FillDB.sql	755296956	admin	2024-02-16 16:30:45.300016	129	t
\.


--
-- TOC entry 3466 (class 0 OID 355235)
-- Dependencies: 219
-- Data for Name: proxy; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.proxy (id, name, description, category, parent_module_id, proxy_type_id) FROM stdin;
60	TK-1160	\N	0	\N	15
54	737	\N	0	56	15
253	728	\N	0	57	15
152	MF211	\N	0	4	1
2	2MK93010 DV-1140(E)	\N	1	\N	11
154	FS-2100D	\N	0	252	0
153	MF4410	\N	0	54	1
202	CAS CNW-460	\N	0	153	6
55	CE285A	\N	0	66	15
155	FS-2100DN	\N	0	252	0
156	FS-4100DN	\N	0	253	0
157	FS-4200dn	\N	0	253	0
158	FS-4300dn	\N	0	253	0
57	HP LJ 1005 -- магнитный вал	\N	2	55	11
56	HP LJ 1010 -- магнитный вал	\N	2	55	11
164	M2030dn	\N	0	79	1
160	M2035dn	\N	0	78	1
161	M2235dn	\N	0	99	1
165	M2530dn	\N	0	79	1
159	M2535dn	\N	0	78	1
168	M2540dn	\N	0	80	1
167	M2640idw	\N	0	80	1
162	M2735dn	\N	0	99	1
163	M2835dn	\N	0	99	1
169	M3040dn	\N	0	255	1
171	M3145dn	\N	0	254	1
172	M3145idn	\N	0	254	1
170	M3540dn	\N	0	255	1
173	M3645dn	\N	0	254	1
174	M3645idn	\N	0	254	1
4	MK - ремкомплект	\N	1	7	11
52	TK-1110	\N	0	58	15
58	TK-1120	\N	0	59	15
166	TK-1130	\N	0	256	15
59	TK-1170	\N	0	60	15
64	TK-1200	\N	0	64	15
63	TK-160	\N	0	63	15
61	TK-3100	\N	0	61	15
65	TK-3160	\N	0	65	15
62	TK-350	\N	0	62	15
1	Барабан для Kyocera Ecosys M2035DN, M2535DN, P2035 для DK-170, DK-150, DK-110, DK-130 (без опорной втулки)	Барабан для Kyocera Ecosys M2035DN, M2535DN, P2035 для DK-170, DK-150, DK-110, DK-130 (без опорной втулки)	2	8	11
104	Выключатель для горячего стола CAS CNW	\N	2	204	11
105	Кулисный переключатель KCD3	\N	2	204	11
103	Нагревательный элемент к CAS CNW-460	\N	2	203	11
102	Панель управления CAS CNW-460	\N	1	202	11
53	ТК-1140	\N	0	52	15
357	Бункер для тонера картриджей Kyocera	\N	1	\N	11
453	RL1-1497 ролик захвата бумаги (Canon/HP 1005/1505)	\N	2	352	11
502	Термопленка RM1-0656-FILM (Canon/HP 1005)	\N	\N	402	\N
302	DK-150 302H493011	\N	2	6	11
303	DV-1130 302MH93020	\N	2	7	11
503	Термоэлемент FM1-F647-Heat (Canon/HP 1005)	\N	\N	403	\N
352	тонер KB02.2	\N	3	302	14
3	DK-170 2LZ93061	\N	1	6	11
355	Тонер KB08.1	Тонер для заправки принтеров Kyocera от фирмы "Булат", черный	3	\N	14
354	Тонер HB15.4	\N	3	303	14
552	Upper для картриджа Canon	\N	1	452	11
702	Дозирующее лезвие HP/Canon 1010	\N	\N	603	\N
553	Lower для картриджа Canon	\N	1	502	11
455	RL1-0266/RC1-2050 Ролик захвата бумаги (Canon/HP 1010)	\N	2	354	11
554	Бункер отработанного тонера для картриджей HP/Canon	\N	1	503	11
504	RM2-5264 | RM2-0426 Блок лазера для принтера Canon/HP	\N	2	404	11
402	Тонер HB08.4	\N	\N	303	\N
452	Печь FM1-F647 (Canon/HP)	\N	\N	257	\N
602	Фотовал для картриджей HP/Canon 1005, 1505	\N	2	8	11
454	RM2-5264 блок лазера (Canon/HP MF211)	\N	1	353	12
652	Ракель 1005, 1505	\N	\N	553	\N
653	Дозирующее лезвие HP/Canon 1005, 1505	\N	\N	552	\N
654	Вал заряда для картриджей Canon/HP 1005, 1505	\N	\N	554	\N
358	Бункер для тонера картриджей Canon/HP	\N	1	\N	11
\.


--
-- TOC entry 3476 (class 0 OID 355370)
-- Dependencies: 229
-- Data for Name: unit; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.unit (id, unit_dic_id) FROM stdin;
\.


--
-- TOC entry 3475 (class 0 OID 355360)
-- Dependencies: 228
-- Data for Name: unit_dic; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.unit_dic (id, name, attr_dic_id) FROM stdin;
\.


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

SELECT pg_catalog.setval('public.attribute_group_seq', 1, true);


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

SELECT pg_catalog.setval('public.element_seq', 651, true);


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

SELECT pg_catalog.setval('public.elements_composite_seq', 751, true);


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

SELECT pg_catalog.setval('public.proxy_seq', 751, true);


--
-- TOC entry 3503 (class 0 OID 0)
-- Dependencies: 238
-- Name: unit_dic_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.unit_dic_seq', 1, false);


-- Completed on 2024-03-11 08:33:30

--
-- PostgreSQL database dump complete
--

