Instalasi Maven:
-----------------------------------
https://maven.apache.org/install.html

Struktur DB:
-----------------------------------
1. User (user_id, password)
2. Operator (operator_id, nama)
3. Voucher (voucher_id, pulsa, harga, operator_id)
4. Transaction (transaction_id, user_id, operator, harga)

Clone Source Code:
-----------------------------------
cd /home/eminaadmin
git clone https://github.com/drei54/pulsa.git

Compile source code:
-----------------------------------
cd pulsa
mvn clean install
mvn spring-boot:run
