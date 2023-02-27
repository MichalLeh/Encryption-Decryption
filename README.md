# Encryption-Decryption

Today, encryption and decryption algorithms are everywhere to protect our data. They are vital for sites that handle sensitive data, such as e-commerce sites that accept online card payments and login areas that require users to enter their credentials. Complex encryption algorithms are behind the scenes to ensure the security of data.
These simple algorithms only illustrate general ideas of encryption.

This is implementation [Hyperskill's](https://hyperskill.org/projects/46) project.

## Description

There are two different algorithms for encoding/decoding. The first one is the shifting algorithm — it shifts each letter by the specified number according to its order in the alphabet (from "a" to "z" and from "A" to "Z". In other words, after "z" comes "a", after "Z" comes "A"). The second one is based on the Unicode table - it shifts each letter by the specified number according to its order in the table.

## Syntax

| Parameters | Values           | Comment |
| -----------| -----------------|---------|
| -mode      | enc<br>dec       | Required<br>Choose to encode or decode input|
| -data      | `<String>`       | Requires at least one (-data OR -in)<br>input text<br>If both -data and -in exist, -data is prioritised|
| -alg       | shift<br>unicode | Required<br>Choose algorithm to use|
| -key       | `<Integer>`      | Not Required<br>default is 0 (no change to input)|
| -in        | `<String>`       | Requires at least one (-data OR -in)<br>input filepath<br>If both -data and -in exist, -data is prioritised|
| -out       | `<String>`       | Not Required<br>output filepath<br>if omitted outputs to console window|

Order of the arguments might vary. For example, -mode enc maybe at the end, at the beginning, or in the middle of the array

## Examples

