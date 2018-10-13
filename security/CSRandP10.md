# CSR and P10

## CSR: Certificate Signing Request
CSR是一个发送到CA的请求认证信息。有两种格式，一种是PKCS#10定义的，另一个用的少的是由SPKAC定义的（主要应用于网景浏览器）

P10定义的CSR有两种编码格式：
二进制，ASN.1或DER（Distinguished Encoding Rules）
文本格式：
the text or PEM(Privacy Enhanced Mail) formatted CSR is the binary CSR after it has been Base-64 encoded to create a text version of the CSR.

.p10一般是一个base64文件