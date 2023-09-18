1. __cat > "Домашние животные"
  Собаки, кошки, хомяки__
2. __cat > "Вьючные животные"
  Лошади, верблюды, ослы__
3. __cat "Домашние животные" "Вьючные животные" > "Общие животные"__
4. __cat "Общие животные"__
5. __mv "Общие животные" "Друзья человека"__
6. __mkdir my_animals__
7. __mv "Друзья человека" my_animals/__
8. __wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb__
9. __sudo dpkg -i mysql-apt-config_0.8.24-1_all.deb__
10. __sudo apt install mysql-server__
11. __sudo service mysql status__
12. __wget http://ftp.us.debian.org/debian/pool/main/s/sl/sl_5.02-1_amd64.deb__
13. __sudo dpkg -i sl_5.02-1_amd64.deb__
14. __sudo dpkg -r sl__
