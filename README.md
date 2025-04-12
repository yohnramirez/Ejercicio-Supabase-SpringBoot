### Crear empleado

```http
  POST /api/empleado/
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`      | `string` | **Required**. Nombre del empleado |
| `cargo`      | `string` | **Required**. Cargo del empleado |
| `telefono`      | `string` | **Required**. Telefono del empleado |

![img.png](images/img.png)

### Crear cliente

```http
  POST /api/cliente/
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`      | `string` | **Required**. Nombre del cliente |
| `cedula`      | `string` | **Required**. Identificacion del cliente |
| `telefono`      | `string` | **Required**. Telefono del cliente |
| `correo`      | `string` | **Required**. Correo del cliente |

![img_1.png](images/img_1.png)

### Crear proveedor

```http
  POST /api/proveedor/
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`      | `string` | **Required**. Nombre del proveedor |
| `direccion`      | `string` | **Required**. Direccion del proveedor |
| `telefono`      | `string` | **Required**. Telefono del proveedor |
| `correo`      | `string` | **Required**. Correo del proveedor |

![img_2.png](images/img_2.png)

### Crear producto

```http
  POST /api/producto/
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`      | `string` | **Required**. Nombre del producto |
| `descripcion`      | `string` | **Required**. Descripcion del producto |
| `precio`      | `double` | **Required**. Precio del producto |
| `stock`      | `int` | **Required**. Stock |
| `proveedor`      | `Proveedor` | **Required**. Referencia proveedor |

![img_3.png](images/img_3.png)

### Crear venta

```http
  POST /api/venta/
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `cliente`      | `Cliente` | **Required**. Referencia cliente |
| `empleado`      | `Empleado` | **Required**. Referencia empleado |

![img_4.png](images/img_4.png)

### Crear detalle de venta

```http
  POST /api/detalle/
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `cantidad`      | `int` | **Required**. Cantidad de productos |
| `precioUnitario`      | `double` | **Required**. Precio unitario del producto |
| `producto`      | `Producto` | **Required**. Referencia producto |
| `venta`      | `Venta` | **Required**. Referencia venta |

![img_5.png](images/img_5.png)

### Obtener los detalles de venta por cliente y empleado

```http
  GET /api/detalle/byEmployeeAndCustomer?idEmployee=${id}&idCustomer=${id}
```

#### Repositorio Spring Boot

![img_6.png](images/img_6.png)

#### Postman

![img_7.png](images/img_7.png)

### Obtener productos que ofrece un proveedor

```http
  GET /api/producto/getBySupplier?idSupplier=${id}
```

#### Repositorio Spring Boot

![img_8.png](images/img_8.png)

#### Postman

![img_9.png](images/img_9.png)

### Obtener ventas por cliente

```http
  GET /api/venta/getByCustomer?idCustomer=${id}
```

#### Repositorio Spring Boot

![img_10.png](images/img_10.png)

#### Postman

![img_11.png](images/img_11.png)

### Obtener ventas por empleado

```http
  GET /api/venta/getByEmployee?idEmployee=${id}
```

#### Repositorio Spring Boot

![img_10.png](images/img_10.png)

#### Postman

![img_12.png](images/img_12.png)




