# Encryption-Decryption

Today, encryption and decryption algorithms are everywhere to protect our data. They are vital for sites that handle sensitive data, such as e-commerce sites that accept online card payments and login areas that require users to enter their credentials. 

Complex encryption algorithms are behind the scenes to ensure the security of data. These simple algorithms only illustrate general ideas of encryption.

This is implementation [Hyperskill's](https://hyperskill.org/projects/46) project.

## Description

There are two different algorithms for encoding/decoding. The first one is the shifting algorithm — it shifts each letter by the specified number according to its order in the alphabet (from "a" to "z" and from "A" to "Z". In other words, after "z" comes "a", after "Z" comes "A"). 

The second one is based on the Unicode table - it shifts each letter by the specified number according to its order in the table.

## Syntax
```
java Main -alg {shift|unicode} -mode {enc|dec} -key n -data "string data" -in filename -out outputfile
```
All the arguments are optional. The parameters may be specified in any order.

| Parameters | Values           | Default |
| -----------| -----------------|---------|
| -mode      | enc<br>dec       | "enc"|
| -data      | `<String>`       | ""   |
| -alg       | shift<br>unicode | "shift"|
| -key       | `<Integer>`      | 0    |
| -in        | `<String>`       |      |
| -out       | `<String>`       |      |

1. Requires at least one (-data OR -in). If both -data and -in exist, -data is prioritised.
2. If -out is omitted, data will be printed to console.

## Examples

#### Encryption with the shift algorithm (by default), output to console 
*Command:*
```
java Main -mode enc -key 5 -data "Welcome to hyperskill!"
```
*Output:*
```
Bjqhtrj yt mdujwxpnqq!
```
#### Decryption with the shift algorithm (by default), output to console 
*Command:*
```
java Main -mode dec -key 5 -data "Bjqhtrj yt mdujwxpnqq!"
```
*Output:*
```
Welcome to hyperskill!
```
#### Encryption with the unicode algorithm, output to console
*Command:*
```
java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
```
*Output:*
```
\jqhtrj%yt%m~ujwxpnqq&
```
#### Encryption with the unicode algorithm 
*Command:*
```
java Main -mode enc -in input.txt -out output.txt -key 10 -alg unicode
```
This command gets data from input.txt, encrypts the data with the key of 10, create output.txt, and write ciphertext into it.
