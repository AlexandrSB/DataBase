--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2024-03-11 08:37:08

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
-- TOC entry 3442 (class 0 OID 347814)
-- Dependencies: 216
-- Data for Name: condition; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.condition (id, name) FROM stdin;
0	Исправные
1	В ремонте
2	В ожидании ремонта
3	Донор
4	Списано
5	На кеше
\.


--
-- TOC entry 3441 (class 0 OID 347809)
-- Dependencies: 215
-- Data for Name: contragent; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.contragent (id, description, name) FROM stdin;
\.


--
-- TOC entry 3447 (class 0 OID 347849)
-- Dependencies: 221
-- Data for Name: equipment; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.equipment (id, prefix_inv_number_id, inventory_number, condition_id, good_id) FROM stdin;
52	1	115122	1	54
54	1	789456	1	52
53	1	105247	1	52
2	1	234567	1	164
1	1	654321	1	202
55	1	897654	1	356
102	1	112233	1	152
3	1	345678	1	160
\.


--
-- TOC entry 3440 (class 0 OID 347800)
-- Dependencies: 214
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1	InitDB Storage	SQL	V1__InitDB_Storage.sql	1110396753	admin	2024-02-15 11:40:47.550591	88	t
2	2	InitSequences	SQL	V2__InitSequences.sql	-1459750388	admin	2024-02-15 11:40:47.696448	30	t
3	2.1	FillSequences	SQL	V2.1__FillSequences.sql	-1370374757	admin	2024-02-15 11:40:47.742196	7	t
4	3	FillCondition	SQL	V3__FillCondition.sql	-1001556508	admin	2024-02-15 11:40:47.759825	3	t
5	4	FillDimension	SQL	V4__FillDimension.sql	-2129763934	admin	2024-02-15 11:40:47.772865	3	t
6	5	FillPrefixInvNumber	SQL	V5__FillPrefixInvNumber.sql	-1773124440	admin	2024-02-15 11:40:47.783896	2	t
\.


--
-- TOC entry 3445 (class 0 OID 347834)
-- Dependencies: 219
-- Data for Name: good; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.good (id, name, category, quantity_account_id) FROM stdin;
54	737	0	\N
53	ТК-1140	0	\N
163	M2835dn	0	\N
153	MF4410	0	\N
157	FS-4200dn	0	\N
253	728	0	\N
173	M3645dn	0	\N
103	Нагревательный элемент к CAS CNW-460	2	\N
152	MF211	0	\N
52	TK-1110	0	\N
64	TK-1200	0	\N
159	M2535dn	0	\N
162	M2735dn	0	\N
60	TK-1160	0	\N
161	M2235dn	0	\N
166	TK-1130	0	\N
168	M2540dn	0	\N
155	FS-2100DN	0	\N
156	FS-4100DN	0	\N
4	MK - ремкомплект	1	\N
58	TK-1120	0	\N
174	M3645idn	0	\N
169	M3040dn	0	\N
105	Кулисный переключатель KCD3	2	\N
170	M3540dn	0	\N
61	TK-3100	0	\N
165	M2530dn	0	\N
172	M3145idn	0	\N
65	TK-3160	0	\N
1	Барабан для Kyocera Ecosys M2035DN, M2535DN, P2035 для DK-170, DK-150, DK-110, DK-130 (без опорной втулки)	2	\N
55	CE285A	0	\N
63	TK-160	0	\N
160	M2035dn	0	\N
57	HP LJ 1005 -- магнитный вал	2	\N
56	HP LJ 1010 -- магнитный вал	2	\N
62	TK-350	0	\N
164	M2030dn	0	\N
104	Выключатель для горячего стола CAS CNW	2	\N
154	FS-2100D	0	\N
59	TK-1170	0	\N
2	2MK93010 DV-1140(E)	1	\N
167	M2640idw	0	\N
171	M3145dn	0	\N
202	CAS CNW-460	0	\N
102	Панель управления CAS CNW-460	1	\N
3	2LZ93061 DK-170	1	\N
158	FS-4300dn	0	\N
303	DV-1130 302MH93020	2	\N
352	тонер KB02.2	3	\N
355	Тонер KB08.1	3	\N
302	DK-150 302H493011	2	\N
354	Тонер HB15.4	3	\N
356	Тонер-картридж для принтеров Kyocera	0	\N
502	Термопленка RM1-0656-FILM (Canon/HP 1005)	\N	\N
358	Бункер для тонера картриджей Canon/HP	\N	\N
357	Бункер для тонера картриджей Kyocera	1	\N
402	Тонер HB08.4	\N	\N
455	RL1-0266/RC1-2050 Ролик захвата бумаги (Canon/HP 1010)	\N	\N
452	Печь FM1-F647 (Canon/HP)	\N	\N
504	RM2-5264 | RM2-0426 Блок лазера для принтера Canon/HP	\N	\N
503	Термоэлемент FM1-F647-Heat (Canon/HP 1005)	\N	\N
453	RL1-1497 ролик захвата бумаги (Canon/HP 1005/1505)	2	\N
454	RM2-5264 блок лазера (Canon/HP MF211)	\N	\N
\.


--
-- TOC entry 3455 (class 0 OID 347955)
-- Dependencies: 229
-- Data for Name: goods_party; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.goods_party (good_id, party_id) FROM stdin;
\.


--
-- TOC entry 3448 (class 0 OID 347871)
-- Dependencies: 222
-- Data for Name: goods_tracking_date; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.goods_tracking_date (id, created_on) FROM stdin;
\.


--
-- TOC entry 3451 (class 0 OID 347888)
-- Dependencies: 225
-- Data for Name: goods_tracking_from_contragent; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.goods_tracking_from_contragent (id, type_of_goods_movement, contragent_id, goods_tracking_date_id, storage_id) FROM stdin;
\.


--
-- TOC entry 3452 (class 0 OID 347909)
-- Dependencies: 226
-- Data for Name: goods_tracking_from_storage; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.goods_tracking_from_storage (id, type_of_goods_movement, goods_tracking_date_id, storage_id, workshop_id) FROM stdin;
\.


--
-- TOC entry 3454 (class 0 OID 347945)
-- Dependencies: 228
-- Data for Name: parcel; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.parcel (id, good_id) FROM stdin;
\.


--
-- TOC entry 3453 (class 0 OID 347930)
-- Dependencies: 227
-- Data for Name: party; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.party (id, name, goods_tracking_from_contragent_id, goods_tracking_from_storage_id) FROM stdin;
\.


--
-- TOC entry 3446 (class 0 OID 347844)
-- Dependencies: 220
-- Data for Name: prefix_inventory_number; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.prefix_inventory_number (id, prefix) FROM stdin;
1	E  
\.


--
-- TOC entry 3443 (class 0 OID 347819)
-- Dependencies: 217
-- Data for Name: quantity; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.quantity (id, dimension, quantity_in_one) FROM stdin;
0	Единица товара	1
1	Упаковка 10 шт.	10
2	Упаковка 50 шт.	50
3	Упаковка 100 шт.	100
4	Коробка 12 шт.	12
5	Коробка 50 шт.	50
\.


--
-- TOC entry 3444 (class 0 OID 347824)
-- Dependencies: 218
-- Data for Name: quantity_account; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.quantity_account (id, quantity, quantity_id) FROM stdin;
\.


--
-- TOC entry 3449 (class 0 OID 347876)
-- Dependencies: 223
-- Data for Name: storage; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.storage (id, description, name) FROM stdin;
\.


--
-- TOC entry 3450 (class 0 OID 347881)
-- Dependencies: 224
-- Data for Name: workshop; Type: TABLE DATA; Schema: public; Owner: admin
--

COPY public.workshop (id, description, name, notice) FROM stdin;
1			\N
\.


--
-- TOC entry 3473 (class 0 OID 0)
-- Dependencies: 230
-- Name: contragent_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.contragent_seq', 1, false);


--
-- TOC entry 3474 (class 0 OID 0)
-- Dependencies: 232
-- Name: equipment_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.equipment_seq', 151, true);


--
-- TOC entry 3475 (class 0 OID 0)
-- Dependencies: 231
-- Name: good_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.good_seq', 1, false);


--
-- TOC entry 3476 (class 0 OID 0)
-- Dependencies: 240
-- Name: goods_tracking_date_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.goods_tracking_date_seq', 1, false);


--
-- TOC entry 3477 (class 0 OID 0)
-- Dependencies: 233
-- Name: goods_tracking_from_contragent_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.goods_tracking_from_contragent_seq', 1, false);


--
-- TOC entry 3478 (class 0 OID 0)
-- Dependencies: 234
-- Name: goods_tracking_from_storage_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.goods_tracking_from_storage_seq', 1, false);


--
-- TOC entry 3479 (class 0 OID 0)
-- Dependencies: 239
-- Name: parcel_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.parcel_seq', 1, false);


--
-- TOC entry 3480 (class 0 OID 0)
-- Dependencies: 235
-- Name: party_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.party_seq', 1, false);


--
-- TOC entry 3481 (class 0 OID 0)
-- Dependencies: 241
-- Name: prefix_inventory_number_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.prefix_inventory_number_seq', 1, true);


--
-- TOC entry 3482 (class 0 OID 0)
-- Dependencies: 238
-- Name: quantity_account_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.quantity_account_seq', 1, false);


--
-- TOC entry 3483 (class 0 OID 0)
-- Dependencies: 236
-- Name: storage_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.storage_seq', 1, false);


--
-- TOC entry 3484 (class 0 OID 0)
-- Dependencies: 237
-- Name: workshop_seq; Type: SEQUENCE SET; Schema: public; Owner: admin
--

SELECT pg_catalog.setval('public.workshop_seq', 1, true);


-- Completed on 2024-03-11 08:37:08

--
-- PostgreSQL database dump complete
--

