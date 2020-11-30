# Grafo

El objetivo de este proyecto es implementar una aplicación para identificar autamáticamente grupos de personas sobre
la base de sus características. Tenemos una lista de personas, y para cada persona i tenemos su nombre y 
los siguientes datos:

di = Interés por los deportes.
mi = Interés por la música.
ei = Interés por las noticias del espectáculo.
ci = Interés por la ciencia.

Caada uno de estos datos se expresa como un entero entre 1 y 5, siendo 1 el menos interés y 5 el 
máximo interés en el tema. Buscamos dividir a esta población en dos grupos con intereses similares.
Para esto utilizaremos el siguiente algoritmo:

1. Construir un grafo completo G con un vértice por cada persona, una arista entre cada par de personas,
y de modo tal que cada arista tiene peso igual al índice de similaridad entre las dos personas.
2. Construir un árbol generador mínimo T de G.
3. Eliminar la arista de mayor peso del árbol T.
4. Las dos componentes conexas del grafo resultante son los dos grupos que estamos buscando.

El índice de similaridad entre dos personas i y j se define como:
similaridad(i,j) = |di - dj| + |mi - mj| + |ei - ej| + |ci - cj|

Esta es una implementación donde cuenta con una interfaz gráfoca para cargar y visualizar los datos
de las personas, y una interfaz para ver los dos grupos que se formaron luego del algoritmo anterior.
