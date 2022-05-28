#language: ru
@card-delivery-replanning
Функционал: Проверка функционала перепланирования доставки банковской карты

	@card-delivery-replanning @positive
	Структура сценария: Перепланирование доставки карты проходит успешно
		И данные пользователя подгружены из файла <file>
		Дано пользователь открыл главную страницу
		И загружена страница "Главная страница"
		Когда заполняются поля:
			| Город             | #{city}     |
			| Дата встречи      | <firstDate> |
			| ФИО               | #{name}     |
			| Мобильный телефон | #{phone}    |
		И выполнено нажатие на Согласие на обработку данных
		И выполнено нажатие на Запланировать
		Тогда загружено диалоговое окно "Оповещение об успехе"
		И выполнено нажатие на Закрыть
		И загружена страница "Главная страница"
		И поле Дата встречи заполняется значением <secondDate>
		И выполнено нажатие на Запланировать
		Тогда загружено диалоговое окно "Оповещение о перепланировании"
		И выполнено нажатие на Перепланировать
		И загружено диалоговое окно "Оповещение об успехе"
		И выполнено нажатие на Закрыть
		Примеры:
			| file                     | firstDate             | secondDate            |
			| GeneratedTestFile_1.json | #{now(dd.MM.yyyy)+3d} | #{now(dd.MM.yyyy)+4d} |
			| GeneratedTestFile_2.json | #{now(dd.MM.yyyy)+1M} | #{now(dd.MM.yyyy)+2M} |
			| GeneratedTestFile_3.json | #{now(dd.MM.yyyy)+1y} | #{now(dd.MM.yyyy)+2y} |

	@card-delivery-replanning @negative
	Структура сценария: Перепланирование доставки карты не происходит, если новая дата доставки раньше, чем текущая + 3 дня
		И данные пользователя подгружены из файла <file>
		Дано пользователь открыл главную страницу
		И загружена страница "Главная страница"
		Когда заполняются поля:
			| Город             | #{city}               |
			| Дата встречи      | #{now(dd.MM.yyyy)+3d} |
			| ФИО               | #{name}               |
			| Мобильный телефон | #{phone}              |
		И выполнено нажатие на Согласие на обработку данных
		И выполнено нажатие на Запланировать
		Тогда загружено диалоговое окно "Оповещение об успехе"
		И выполнено нажатие на Закрыть
		И загружена страница "Главная страница"
		И поле Дата встречи заполняется значением <date>
		И выполнено нажатие на Запланировать
		И поле Неподходящая дата видимо
		Примеры:
			| file                      | date                  |
			| GeneratedTestFile_4.json  | #{now(dd.MM.yyyy)-1d} |
			| GeneratedTestFile_5.json  | #{now(dd.MM.yyyy)}    |
			| GeneratedTestFile_6.json  | #{now(dd.MM.yyyy)+1d} |
			| GeneratedTestFile_7.json  | #{now(dd.MM.yyyy)+2d} |
			| GeneratedTestFile_8.json  | #{now(dd.MM.yyyy)-1M} |
			| GeneratedTestFile_9.json  | #{now(dd.MM.yyyy)-1y} |
			| GeneratedTestFile_10.json | 01.01.0001            |

	@card-delivery-replanning @negative
	Структура сценария: Перепланирование доставки карты не происходит, если новая дата доставки задана неверно
		И данные пользователя подгружены из файла <file>
		Дано пользователь открыл главную страницу
		И загружена страница "Главная страница"
		Когда заполняются поля:
			| Город             | #{city}               |
			| Дата встречи      | #{now(dd.MM.yyyy)+3d} |
			| ФИО               | #{name}               |
			| Мобильный телефон | #{phone}              |
		И выполнено нажатие на Согласие на обработку данных
		И выполнено нажатие на Запланировать
		Тогда загружено диалоговое окно "Оповещение об успехе"
		И выполнено нажатие на Закрыть
		И загружена страница "Главная страница"
		Когда поле Дата встречи заполняется значением <date>
		И выполнено нажатие на Запланировать
		И поле Неверно заданная дата видимо
		Примеры:
			| file                      | date       |
			| GeneratedTestFile_11.json | 29.02.2075 |
			| GeneratedTestFile_12.json | 31.04.2080 |
			| GeneratedTestFile_13.json | 50.01.2100 |
			| GeneratedTestFile_14.json | 12.13.2150 |
			| GeneratedTestFile_15.json | 00.01.2170 |
			| GeneratedTestFile_19.json | 05.00.2190 |
			| GeneratedTestFile_20.json |            |

	@card-delivery-replanning @negative
	Структура сценария: При изменении поля, отличного от даты, сервис не осуществляет перепланирование, а создает новое
		И данные пользователя подгружены из файла <file>
		Дано пользователь открыл главную страницу
		И загружена страница "Главная страница"
		Когда заполняются поля:
			| Город             | #{city}               |
			| Дата встречи      | #{now(dd.MM.yyyy)+3d} |
			| ФИО               | #{name}               |
			| Мобильный телефон | #{phone}              |
		И выполнено нажатие на Согласие на обработку данных
		И выполнено нажатие на Запланировать
		Тогда загружено диалоговое окно "Оповещение об успехе"
		И выполнено нажатие на Закрыть
		И загружена страница "Главная страница"
		И поле <field> заполняется значением <newValue>
		И выполнено нажатие на Запланировать
		И загружено диалоговое окно "Оповещение об успехе"
		И выполнено нажатие на Закрыть
		Примеры:
			| file                      | field             | newValue       |
			| GeneratedTestFile_21.json | Город             | #{secondCity}  |
			| GeneratedTestFile_22.json | ФИО               | #{secondName}  |
			| GeneratedTestFile_23.json | Мобильный телефон | #{secondPhone} |