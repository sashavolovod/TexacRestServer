#/bin/bash

echo "Копирование файла на целевой сервер"
scp target/texac-0.0.1-SNAPSHOT.jar 172.16.11.173:/home/udly/www/
echo "Файл скопирован"
ssh -t 172.16.11.173 "sudo /home/udly/www/update.sh"
echo "Сервис перезапущен"