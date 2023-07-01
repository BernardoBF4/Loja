(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logica :as l.logic]))

(defn gastou-bastante?
  [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep =>" (keep gastou-bastante? resumo)))



(println "################")

(defn gastou-bastante?
  [info-do-usuario]
  (println "gastou-bastante?" (:usuario-id info-do-usuario))
  (> (:preco-total info-do-usuario) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep =>" (keep gastou-bastante? resumo))
  (println "filter =>" (filter gastou-bastante? resumo)))

(println "\r\n Vamos isolar...")

(println (range 10))
(println (take 2 (range 10000000000000000000000000000000000000)))
; a sequência não está sendo gulosa -> eager
(let [sequencia (range 1000000000000000000000)]
  (println (take 2 sequencia))
  (println (take 2 sequencia))
  (println (take 2 (rest sequencia))))
; está sendo LAZY = não EAGER


(defn filtro1
  [x]
  (println "filtro1" x)
  x)

(println (map filtro1 (range 10)))

(defn filtro2
  [x]
  (println "filtro2" x)
  x)

(println (map filtro2 (map filtro1 (range 10))))

(->> (range 10)
     (map filtro1)
     (map filtro2)
     println)

; Chunks de 32 itens
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)

; O "mapv" não tem chunks
(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)

; Map com vetor é lazy
(->> [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29]
     (map filtro1)
     (map filtro2)
     println)

; Lista ligada é 100%$ lazy
(->> '(0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29)
     (map filtro1)
     (map filtro2)
     println)

































