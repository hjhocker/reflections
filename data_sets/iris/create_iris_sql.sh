#!/bin/bash

count=1

while read line
do
  id=$count
  sepal_length=$(echo $line | cut -d',' -f2)
  sepal_width=$(echo $line | cut -d',' -f3)
  petal_length=$(echo $line | cut -d',' -f4)
  petal_width=$(echo $line | cut -d',' -f5)
  species=$(echo $line | awk -F',' '{print $6}')
  count=$(($count+1))
  printf "insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values ($id, $sepal_length, $sepal_width, $petal_length, $petal_width, '$species');\n"
done < iris.csv
