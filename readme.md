# Prueba tecnica

### Problema
Escriba un servicio que haga un análisis y conteo de caracteres en un texto de tal forma que pueda obtener la siguiente información:

1) Cantidad de caracteres totales (incluyendo espacios en blanco)
2) Cantidad de caracteres numéricos (dígitos de 0-9)
3) Cantidad de letras (totales)
4) Cantidad de letras (minúsculas)
5) Cantidad de letras (mayúsculas)
6) Cantidad de espacios en blanco (todo tipo)
7) Cantidad de caracteres de puntuación
8) Cantidad de palabras
9) Top 10 caracteres presentes (ordenados de mayor presencia a menor presencia) con su respectivo conteo de presencia del caracter (y el porcentaje relativo al total de caracteres)

### Solucion
Se diseño un api rest que expone dos servicios encargados de procesar los textos. Para ello se abodaron dos formas, la primera usando el api estandar de java y por cada letra del mensaje se aplicó un metodo que retornara si un caracter coincidia o no con una caracteristica establecida. La segunda forma fue usando streams lo que simplificó en muchos casos el procesamiento de los caracteres que componian el texto.

URL: localhost:8080/api/text
Metodo: POST 
Body: {"text": ""}
Endpoint usando api estandar de java

URL: localhost:8080/api/text/v2
Metodo: POST 
Body: {"text": ""}
Endpoint usando stream de java