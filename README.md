# Тестовое задание для осенней стажировки в РЕЛЭКС

### Задание выполнял Илья Шаталов


* [Демонстрация работы приложения](https://drive.google.com/file/d/1dl4JdrfljRyGUqzuKHFLuin9DfBDSTty/view?usp=sharing)


## Запросы и ответы на них

#### Передача пути файла:
```
http://localhost:8080/enterPath?filePath=src%2Fmain%2Fresources%2Fstatic%2F10m.txt
```
#### Поиск максимального значения:
```
Request URL:
http://localhost:8080/getMaxValue
Response body:
max value: 49999978
```
#### Поиск минимального значения:
```
Request URL:
http://localhost:8080/getMinValue
Response body:
min value: -49999996
```
#### Поиск медианы:
```
Request URL:
http://localhost:8080/getMedian
Response body:
median: 25216
```
#### Поиск среднего арифметического значения:
```
Request URL:
http://localhost:8080/getAverage
Response body:
average: 7364.418442641844
```
#### Поиск самой длинной восходящей последовательности:
```
Request URL:
http://localhost:8080/getLongestAscendingSequence
Response body:
longest ascending sequence: [[-48190694, -47725447, -43038241, -20190291, -17190728, -6172572, 8475960, 25205909, 48332507, 48676185]]
```
#### Поиск самой длинной нисходящей последовательности:
```
Request URL:
http://localhost:8080/getLongestDescendingSequence
Response body:
longest descending sequence: [[47689379, 42381213, 30043880, 12102356, -4774057, -5157723, -11217378, -23005285, -23016933, -39209115, -49148762]]
```


