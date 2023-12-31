## Алгоритмы

### Лекция 1

#### Оценка сложности алгоритма
Это абстрактная величина, она не призвана,
для того чтобы сделать точный расчет, она лишь призвана для того чтобы оценить
насколько сильно будет меняться количество операций относительно роста входящих данных.

#### Какая бывает сложность алгоритмов
Тайминг 41:20

- O(1) константная. Не зависит от объема данных.
Например поиск по хэш таблице
- O(log n) логарифмическая. Увеличение размера
почти не сказывается на количестве итераций.
Например бинарный поиск, поиск по
сбалансированному дереву
- O(n) линейная. Увеличение сложности эквивалентно
увеличению размера. Например поиск по
неотсортированному массиву
- O(n * log n) увеличение размера заметно
сказывается на сложности. Например быстрая
сортировка
- O(n^2) квадратичная. Увеличение размера очень
сильно сказывается на сложности. Например
пузырьковая сортировка
- O(2^n) экспоненциальная. С увеличением размера
на 1, сложность возрастает вдвое

#### Линейная сложность
O(n) при увеличении обьема данных мы на столько же
увеличим количество итераций.

```java
for (int i = 0; i < n; i++){
    //do something
}
```

#### Квадратичная сложность 
O(n^2) при увеличении обьема данных мы в квадрате
увеличим количество итераций.

```java
for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            //do something
        }
}
```

#### Экспоненциальная сложность
Число итераций растет огромными темпами.    
Например, числа фибонначи.

```java
public static int fib(int position){
    if(position == 1){
        return 0;
    }
    if(position == 2){
        return 1;
    }
    return fib(position - 1) + fib(position - 2);
}
```

#### Правила обьединения сложностей
Тайминг 35:20

Мы не гонимся за ситуацией при которой нам нужно точно рассчитать количество
шагов которое нам необходимо будет выполнить.

Целочисленные показатели откидываются, 
при вызове нескольких методов на каждом шаге.

O(2n) == O(n)   
O(n/2) == O(n)  
O(2+n) == O(n)

Если один алгоритм вызывается внутри 
второго алгоритма, то его сложности перемножаются.

O(n^3) * O(n^2) == O(n^5)

Если алгоритмы выполняются последовательно, то их сложности складываются.
Берется максимальная из возможных оценок.

O(n^3) + O(n^2) == O(n^3)

### Лекция 2

#### Структурами данных
называют некоторый контейнер с данными, 
обладающий специфическим внутренним устройством
и логикой хранения Различные макеты могут быть эффективны 
для некоторых операций и неэффективны для других.

#### Массив
это контейнер, хранящий данные идентифицируемые по индексу
К любому элементу массива всегда можно обратиться по его индексу и
достать или заменить его
Особенностью
массива является то, что доступ к элементам по индексу
осуществляется за константное время, т е имеет сложность O(1)

#### Основные операции с массивом

- Простые алгоритмы сортировки
- Алгоритмы поиска
- Продвинутые алгоритмы сортировки

#### Базовые алгоритмы сортировки:

Пузырьковая сортировка (сложность поиска O(n^2))    
Сортировка выбором (сложность поиска O(n^2))    
Сортировка вставками (сложность поиска O(n^2))

#### Базовые алгоритмы поиска

Перед поиском требуется сортировка.

- Простой перебор (сложность O(n))
- Бинарный поиск (сложность O(log n))

#### Продвинутые алгоритмы сортировки

- Быстрая сортировка (сложность поиска O(n * log n))

- Пирамидальная сортировка (сложность поиска O(n * log n)), тайминг в лекции 57:30    
[Структура данных Heap - куча или пирамида](https://www.youtube.com/watch?v=noQ4SUoqrQA)  
[Сортировка кучи - пирамидальная сортировка HeapSort](https://www.youtube.com/watch?v=92yCSMwsz88)    
[Пирамидальная сортировка (HeapSort) Habr](https://habr.com/ru/companies/otus/articles/460087/)

### Лекция 3

LinkedList - связанный список

Бинарный поиск не предназначен для работы со связанными списками, 
из-за отсутствия работы по индексам которая присутствует в классическом массиве.

Методы работы со связанными списками: 

- Поиск элемента O(n)
- Вставка элемента(добавление)
  - Вставка в конец O(1)
  - Вставка в середину O(n)
- Удаление элемента
- Разворот списка
- Сортировка списка

Массив можно использовать для быстрого поиска элемента по индексу

Преимущества связанного списка:

- Массовые вставки и удаления в конец начало списка
- Массовые вставки и удаления в середину списка, если операция поиска выполняется единожды
- Динамическая расширяемость

Односвязный список используется для специфической работы со стеком.

Двусвязный список для работы с очередями.

Стек и очередь это частные случаи связанного списка.

### Лекция 4

Поиск элементов в структуре дерево:

Обход в глубину - первый самый часто используемый.

Обход в ширину

Бинарное дерево - частный случай дерева.

Сбалансированное дерево - частный случай бинарного дерева.

Красно черное дерево - лекция тайминг 28:00

