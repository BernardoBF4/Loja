(ns loja.aula2)

(def nomes ["Bernardo" "Ana" "Paula" "João" "Thiago"])

; Função sem condição de parada; vai dar StackOverflow
(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora) (rest elementos)))




(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))))




; Solução que soma retorna "1" mesmo que a sequência seja vazia
(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (next elementos))
    (inc total-ate-agora)))




; A solução funciona, mas é necessário passar o inicializador "0", o que não é muito legal
(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))





; Definindo uma variação para a função
(defn minha-funcao
  ([parametro1] (println "Só um parâmetro" parametro1))
  ([parametro1 parametro2] (println "Dois parâmetros" parametro1 "e" parametro2)))

(minha-funcao 1 2)






(defn conta
  ([elementos] (conta 0 elementos))
  ([total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora)))

(println (conta nomes))
(println (conta [false false]))
(println (conta [nil nil]))
(println (conta [true true]))
(println (conta []))
(println (conta nil))













