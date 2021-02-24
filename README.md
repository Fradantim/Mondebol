# Mondebol
Una api simple para recuperar monstruos de bolsillo, y un ejemplo rápido de como implementar SpringSecurity.
Para autenticar el usuario y la contraseña deben ser iguales.

[RFC7617   The 'Basic' HTTP Authentication Scheme](https://tools.ietf.org/html/rfc7617) / [Basic authentication header generator](https://www.blitter.se/utils/basic-authentication-header-generator/ 
)
> Basic Authorization Header: “Basic ”+Base64(usuario+”:”+password)

Ejemplo:
```
Usuario: Franco
Contraseña: Franco

-> “Basic “+Base64(”Franco:Franco”)
-> “Basic RnJhbmNvOkZyYW5jbw==”
```

Test
```bat
curl http://localhost:8080/mondebol3 -H "Authorization:Basic RnJhbmNvOkZyYW5jbw=="
```
> Hola Franco, veo que tus roles son [ROL_ESPECIFICO_1, ROL_ESPECIFICO_2] toma un mondebol: Kabuto
