# sales-order-service
Sales Shipping Service

 java -javaagent:/Users/jim/workspace/metaform/samples/sales/newrelic/shipping/newrelic.jar  -jar target/sales-shipping-serivce-1.0.0.jar --server.port=9000

 java -javaagent:[newrelic.jar] -jar target/sales-shipping-serivce-1.0.0.jar --server.port=9000


curl -H "Content-Type: application/json" -d '{"item":"1234","quantity":1}' localhost:9000/shipping/

