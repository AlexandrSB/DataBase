--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2024-03-11 08:37:36

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
-- TOC entry 3423 (class 0 OID 371344)
-- Dependencies: 218
-- Data for Name: completed_work; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.completed_work (id, notation, spare_part_id, repair_type) FROM stdin;
1	Заправка картриджа	303	1
152	Замена термопленки	402	1
153	Замена термоэлемента	403	1
154	Замена блока лазера	404	1
302	Замена ролика захвата бумаги	354	1
352	Замена фотовала	8	1
402	Чистка бункера отработанного тонера	\N	1
403	Замена фотовала	8	1
502	Чистка бункера отработанного тонера	\N	1
553	Замена ракеля	553	1
554	Замена вала заряда	554	1
557	Заправка картриджа	303	1
602	Замена магнитного вала	55	1
603	Замена дозирующего лезвия	552	1
604	Замена магнитного вала 1010	602	1
605	Замена дозирующего лезвия 1010	603	1
\.


--
-- TOC entry 3430 (class 0 OID 371427)
-- Dependencies: 225
-- Data for Name: consumption_of_material; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.consumption_of_material (id, quantity_of_material, type_of_spare_part_id, completed_work_id, repair_card_of_module_id, workshop_module_id) FROM stdin;
1	1	354	1	42fec9a5-4884-44dc-b4ec-a276596012ae	fbc6bed2-be13-4dbb-b1f5-e8f0f1411213
52	1	354	1	a0bc7392-7f2d-49f0-8a17-01e3f02c4a2e	1e2b7a10-5652-4c1f-86c7-55510bad4ceb
53	1	504	154	8388632e-998e-4a20-8e06-47128c03da44	a5bb31cb-38cf-4fc1-8d14-88d2489d94bc
103	1	503	153	2d62212a-89a4-4675-9b0f-d71f13bbe655	ff7e543e-f4d2-44bd-88a0-b80b73444469
104	1	502	152	2d62212a-89a4-4675-9b0f-d71f13bbe655	ff7e543e-f4d2-44bd-88a0-b80b73444469
202	1	453	302	379da20a-56e7-4903-ac1e-3083593bc10b	7ab9170e-aaea-40ab-a831-c19756e81524
252	1	602	403	35fdfedc-2040-4ad8-9e1f-5751fa996af2	2bf70950-8461-4962-b8b8-b501528b3125
302	0	\N	502	35fdfedc-2040-4ad8-9e1f-5751fa996af2	2bf70950-8461-4962-b8b8-b501528b3125
\.


--
-- TOC entry 3419 (class 0 OID 371310)
-- Dependencies: 214
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1	InitDB Workshop	SQL	V1__InitDB_Workshop.sql	-527802426	admin	2024-02-20 12:28:28.550617	89	t
2	2	InitSequencesDB Workshop	SQL	V2__InitSequencesDB_Workshop.sql	634465108	admin	2024-02-20 12:28:28.701843	17	t
\.


--
-- TOC entry 3427 (class 0 OID 371386)
-- Dependencies: 222
-- Data for Name: repair_card_of_equipment; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.repair_card_of_equipment (id, equipment_name, begin_repair_timestamp, end_repair_timestamp, repair_type, workshop_element_id) FROM stdin;
d7a3791a-9283-4e78-ab37-c36d5d59d771	737	2024-02-20 12:29:53.855799+08	\N	1	52
50225b66-5de0-4269-a0b8-87061bdab2b6	TK-1110	2024-02-20 12:29:56.521362+08	\N	1	54
2048114d-828d-4ab7-af4d-a25d05b1925c	TK-1110	2024-02-20 12:29:58.52328+08	\N	1	53
b93f484e-3b28-40db-821d-a8adf4863656	M2030dn	2024-02-20 12:30:03.921292+08	\N	1	2
fc166ecf-c5ab-4e64-9cfc-6cc00331a7c1	CAS CNW-460	2024-02-20 12:30:06.361697+08	\N	1	1
24a3ea55-0e8c-43f5-bcaa-baf1ccdd9934	Тонер-картридж для принтеров Kyocera	2024-02-20 12:30:08.858181+08	\N	1	55
cb982856-ca05-4958-9c38-8557653d5229	MF211	2024-02-20 15:02:44.419625+08	\N	1	102
27a96aaf-0b5b-47a9-a32c-5088e443e79d	M2035dn	2024-02-21 14:54:34.284105+08	2024-02-21 14:54:34.280346+08	1	3
3f1efbdc-3114-4388-8b19-47d5b8c81dbe	M2035dn	2024-03-04 11:32:44.928908+08	\N	0	3
\.


--
-- TOC entry 3429 (class 0 OID 371412)
-- Dependencies: 224
-- Data for Name: repair_card_of_module; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.repair_card_of_module (id, repair_card_of_equipment_id, workshop_module_id) FROM stdin;
42fec9a5-4884-44dc-b4ec-a276596012ae	27a96aaf-0b5b-47a9-a32c-5088e443e79d	fbc6bed2-be13-4dbb-b1f5-e8f0f1411213
379da20a-56e7-4903-ac1e-3083593bc10b	cb982856-ca05-4958-9c38-8557653d5229	7ab9170e-aaea-40ab-a831-c19756e81524
a0bc7392-7f2d-49f0-8a17-01e3f02c4a2e	cb982856-ca05-4958-9c38-8557653d5229	1e2b7a10-5652-4c1f-86c7-55510bad4ceb
8388632e-998e-4a20-8e06-47128c03da44	cb982856-ca05-4958-9c38-8557653d5229	a5bb31cb-38cf-4fc1-8d14-88d2489d94bc
2d62212a-89a4-4675-9b0f-d71f13bbe655	cb982856-ca05-4958-9c38-8557653d5229	ff7e543e-f4d2-44bd-88a0-b80b73444469
35fdfedc-2040-4ad8-9e1f-5751fa996af2	d7a3791a-9283-4e78-ab37-c36d5d59d771	2bf70950-8461-4962-b8b8-b501528b3125
\.


--
-- TOC entry 3421 (class 0 OID 371324)
-- Dependencies: 216
-- Data for Name: spare_part; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.spare_part (id, name, workshop_unit_id) FROM stdin;
303	Тонер для принтеров Canon/HP (монохромная печать)	\N
354	Ролик захвата бумаги (Canon/HP)	\N
352	Узел захвата бумаги с нижнего лотка	\N
402	Термопленка	\N
403	Термоэлемент (Тэн) для лазерных принтеров	\N
404	Блок лазера для принтера Canon/HP	\N
8	Фотовал	\N
452	Upper для картриджей HP/Canon	\N
553	Ракель	\N
554	Вал заряда (коротрон)	\N
55	Магнитный вал для картриджей Canon/HP 1005, 1505	\N
552	Дозирующее лезвие (Doctor Blade) для картриджей Canon/HP 1005, 1505	\N
602	Магнитный вал для принтеров Canon/HP 1010	\N
603	Дозирующее лезвие (Doctor Blade) для картриджей Canon/HP 1010	\N
\.


--
-- TOC entry 3431 (class 0 OID 371452)
-- Dependencies: 226
-- Data for Name: type_of_operation; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.type_of_operation (id, operation_type, completed_work_id, unit_id) FROM stdin;
1	0	1	305
152	0	152	257
153	0	153	257
154	0	154	353
302	0	302	352
352	0	352	6
402	2	402	503
403	0	403	452
502	2	502	452
553	0	553	452
554	0	554	452
557	0	557	502
602	0	602	502
603	0	603	502
604	0	604	502
605	0	605	502
\.


--
-- TOC entry 3422 (class 0 OID 371334)
-- Dependencies: 217
-- Data for Name: type_of_spare_part; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.type_of_spare_part (id, name, spare_part_id) FROM stdin;
354	Тонер HB15.4	303
453	RL1-1497 ролик захвата бумаги (Canon/HP 1005/1505)	352
504	RM2-5264 | RM2-0426 Блок лазера для принтера Canon/HP	404
503	Термоэлемент FM1-F647-Heat (Canon/HP 1005)	403
502	Термопленка RM1-0656-FILM (Canon/HP 1005)	402
602	Фотовал для картриджей HP/Canon 1005, 1505	452
\.


--
-- TOC entry 3426 (class 0 OID 371371)
-- Dependencies: 221
-- Data for Name: workshop_element; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.workshop_element (id, prefix_inventory_number, inventory_number, proxy_id, equipment_id) FROM stdin;
52	E  	115122	\N	\N
54	E  	789456	\N	\N
53	E  	105247	\N	\N
3	E  	345678	\N	\N
2	E  	234567	\N	\N
1	E  	654321	\N	\N
55	E  	897654	\N	\N
102	E  	112233	\N	\N
\.


--
-- TOC entry 3424 (class 0 OID 371356)
-- Dependencies: 219
-- Data for Name: workshop_equipment; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.workshop_equipment (id, name) FROM stdin;
109	Kyocera ECOSYS P3145dn
92	Kyocera FS-3140MFP+
97	Kyocera Ecosys P2035d/dn
74	Kyocera FS-1025MFP
68	Kyocera P2040dn
77	Kyocera FS-1135MFP
69	Kyocera P2040dw
1	Kyocera FS-2035
252	Kyocera Ecosys FS-2100
3	Kyocera FS-1030
4	Canon MF211
106	Kyocera ECOSYS P3155dn
94	Kyocera FS-3540MFP
153	Горячий стол CAS
72	Kyocera FS-1120MFP
78	Kyocera ECOSYS M2035/M2535
67	Kyocera M2040dn
75	Kyocera FS-1125
103	Kyocera ECOSYS P3050dn
104	Kyocera ECOSYS P3055dn
96	Kyocera FS-1120D/DN
70	Kyocera FS-1040
98	Kyocera ECOSYS P2335d/dn/dw
90	Kyocera FS-3920DN
253	Kyocera Ecosys FS-4100/FS-4200/FS-4300
79	Kyocera ECOSYS M2030/M2530
255	Kyocera Ecosys M3040/M3540
105	Kyocera ECOSYS P3060dn
76	Kyocera FS-1035MFP/DP
110	Kyocera ECOSYS P3150dn
99	Kyocera ECOSYS M2235/M2735/M2835
73	Kyocera FS-1060dn
102	Kyocera ECOSYS P3045dn
54	Canon MF4410
71	Kyocera FS-1020MFP
95	Kyocera FS-3640MFP
91	Kyocera FS-3040MFP+
254	Kyocera Ecosys M3145/ M3645
93	Kyocera FS-3040
80	Kyocera ECOSYS M2540/ M2640
\.


--
-- TOC entry 3428 (class 0 OID 371397)
-- Dependencies: 223
-- Data for Name: workshop_module; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.workshop_module (id, name, workshop_element_id, workshop_unit_id) FROM stdin;
fd99ff2f-0b72-49ee-988a-6752a20f0223	Тонер для принтеров Canon/HP (монохромная печать)	52	303
7621349d-1e86-4109-bb12-8bfca1ece22e	Бункер для тонера	52	305
36eea413-b17b-4e97-8990-7acc02ce8975	Бункер для тонера	53	305
933b7307-0d40-4509-9fcc-e70d83df7498	Тонер для принтеров Kyocera (монохромная печать)	53	302
d5d7ce9e-9cbe-4452-ac3d-92077d6cd000	Картридж Kyocera TK-1140	3	52
fbc6bed2-be13-4dbb-b1f5-e8f0f1411213	Бункер для тонера	3	305
aa0037ea-e348-4241-9258-778719654db1	Картридж Kyocera TK-1130	2	256
1aaaa79a-6956-4cc0-b7b9-4fb4105f1fcf	Бункер для тонера	2	305
39ced948-13d2-434f-a3ce-9fbcf9313303	DRAM	2	6
e150b8b7-aeb7-47ce-b4cd-ec427ba4e9b8	MK	2	7
2e9c8bbd-0b60-4790-ace8-487c7efdbdba	Картридж Canon/HP 737	102	56
1e2b7a10-5652-4c1f-86c7-55510bad4ceb	Бункер для тонера	102	305
ff7e543e-f4d2-44bd-88a0-b80b73444469	Узел термозакрепления (печь)	102	257
7ab9170e-aaea-40ab-a831-c19756e81524	Узел захвата бумаги с нижнего лотка	102	352
a5bb31cb-38cf-4fc1-8d14-88d2489d94bc	Блок лазера	102	353
4b7fcfc7-f614-4248-a6ee-d2a847267bd4	Панель управления горячим столом	1	202
41a5485e-4f54-4f7d-b50c-261fb998ccb1	Ролик захвата бумаги (Canon/HP)	102	354
86106857-df7c-4201-a47f-897716161472	DRAM	3	6
2bf70950-8461-4962-b8b8-b501528b3125	Upper для картриджей HP/Canon	52	452
df041097-2452-4137-aa80-255c886268e7	Бункер отработанного тонера для картриджей HP/Canon	52	503
b96128b0-a67a-4069-bce7-7e986309edbb	Фотовал	52	8
f36e0732-fc1f-4599-ac58-9feda141f653	Lower для картриджей HP/Canon	52	502
\.


--
-- TOC entry 3425 (class 0 OID 371361)
-- Dependencies: 220
-- Data for Name: workshop_proxy; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.workshop_proxy (id, name, equipment_id) FROM stdin;
154	FS-2100D	252
152	MF211	4
153	MF4410	54
160	M2035dn	1
\.


--
-- TOC entry 3420 (class 0 OID 371319)
-- Dependencies: 215
-- Data for Name: workshop_unit; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.workshop_unit (id, name) FROM stdin;
303	Тонер для принтеров Canon/HP (монохромная печать)
305	Бункер для тонера
302	Тонер для принтеров Kyocera (монохромная печать)
52	Картридж Kyocera TK-1140
256	Картридж Kyocera TK-1130
6	DRAM
7	MK
56	Картридж Canon/HP 737
257	Узел термозакрепления (печь)
352	Узел захвата бумаги с нижнего лотка
353	Блок лазера
202	Панель управления горячим столом
354	Ролик захвата бумаги (Canon/HP)
57	Картридж Canon/HP 728
66	Картридж Canon/HP CE285A
58	Картридж Kyocera TK-1110
59	Картридж Kyocera TK-1120
82	Картридж Kyocera TK-1160
60	Картридж Kyocera TK-1170
64	Картридж Kyocera TK-1200
63	Картридж Kyocera TK-160
61	Картридж Kyocera TK-3100
65	Картридж Kyocera TK-3160
62	Картридж Kyocera TK-350
5	Ремкомплект
452	Upper для картриджей HP/Canon
503	Бункер отработанного тонера для картриджей HP/Canon
8	Фотовал
502	Lower для картриджей HP/Canon
\.


--
-- TOC entry 3447 (class 0 OID 0)
-- Dependencies: 227
-- Name: completed_work_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.completed_work_seq', 651, true);


--
-- TOC entry 3448 (class 0 OID 0)
-- Dependencies: 228
-- Name: consumption_of_material_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.consumption_of_material_seq', 351, true);


--
-- TOC entry 3449 (class 0 OID 0)
-- Dependencies: 229
-- Name: spare_part_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.spare_part_seq', 1, false);


--
-- TOC entry 3450 (class 0 OID 0)
-- Dependencies: 230
-- Name: type_of_operation_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.type_of_operation_seq', 651, true);


--
-- TOC entry 3451 (class 0 OID 0)
-- Dependencies: 231
-- Name: type_of_spare_part_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.type_of_spare_part_seq', 1, false);


--
-- TOC entry 3452 (class 0 OID 0)
-- Dependencies: 234
-- Name: workshop_element_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.workshop_element_seq', 1, false);


--
-- TOC entry 3453 (class 0 OID 0)
-- Dependencies: 233
-- Name: workshop_equipment_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.workshop_equipment_seq', 1, false);


--
-- TOC entry 3454 (class 0 OID 0)
-- Dependencies: 236
-- Name: workshop_module_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.workshop_module_seq', 1, false);


--
-- TOC entry 3455 (class 0 OID 0)
-- Dependencies: 235
-- Name: workshop_proxy_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.workshop_proxy_seq', 1, false);


--
-- TOC entry 3456 (class 0 OID 0)
-- Dependencies: 232
-- Name: workshop_unit_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.workshop_unit_seq', 1, false);


-- Completed on 2024-03-11 08:37:36

--
-- PostgreSQL database dump complete
--

