(ns loja.core)

(def nomes ["Bernardo" "Ana" "Paula" "João" "Thiago"])

(println (first nomes))
(println (next nomes))                                      ; Pega o próximo
(println (rest nomes))                                      ; Pega o resto
(println (rest []))                                         ; Retorna uma sequência vazia
(println (next []))                                         ; Retorna nulo
(println (seq []))                                          ; Retorna nulo
(println (seq [1 2 3 4]))                                   ; Retorna uma sequência vazia


; Minha função de "map" -> esta é a minha solução.
; A minha printa os valores "[nil nil]" e o "nil", mas a do professor não
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (let [resto (rest sequencia)]
      (if (next resto)
        (meu-mapa funcao resto)
        (funcao (last sequencia))))))

(meu-mapa println nomes)
(meu-mapa println [false false])
(meu-mapa println [nil nil])
(meu-mapa println [true true])
(meu-mapa println [])
(meu-mapa println nil)
; (meu-mapa println (range 100000))



; Função do professor -> a solução do professor parece melhor porque define uma variável a menos
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(meu-mapa println nomes)
(meu-mapa println [false false])
(meu-mapa println [nil nil])
(meu-mapa println [true true])
(meu-mapa println [])
(meu-mapa println nil)
; (meu-mapa println (range 100000))







; O recur (que deve ser uma das útlimas coisas chamadas, é um laço, e permite que
; a memória seja melhor alocada, não deixando todos os itens da stack armazenados para
; depois serem retornados, mas sim, usando cada item e eliminando ele.
; Aliás, isso se chama TAIL RECURSION, porque a função se chama (com o "recur") na última
; coisa que ela faz dentro do corpo dela
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

(meu-mapa println (range 100000))

; Abaixo não é TAIL RECURSION, porque o "recur" não é a última coisa no corpo da função
;(defn meu-mapa
;  [funcao sequencia]
;  (let [primeiro (first sequencia)]
;    (if (not (nil? primeiro))
;      (do
;        (recur funcao (rest sequencia))
;        (funcao primeiro)))))









