;; Contract Proposal Generator
;; Author: Edoardo Sabatini
;; Date: August 4th, 2025
;; A sophisticated Clojure application for generating Italian employment contract proposals
;; with structured terms, bonus calculations, and legal conditions

;; The 'ns' macro defines our namespace - the logical unit that contains our functions and data
;; This is Clojure's way of organizing code into modules, similar to packages in Java
(ns contract.proposal
  "Contract proposal generator in Clojure - handles complex employment terms and calculations"
  ;; The :require directive imports external namespaces we need
  ;; clojure.string provides string manipulation utilities (join, split, etc.)
  (:require [clojure.string :as str]))

;; 'def' creates a global var binding - this is our main data structure
;; Using a map (hash-map) to store all contract terms in a structured way
;; Maps in Clojure are immutable and provide O(log32 N) access time
(def contract-terms
  {;; Keywords (:keyword) are interned symbols that eval to themselves
   ;; They're commonly used as map keys for performance and clarity
   :net-bonus           36000    ; Total net bonus amount in euros
   :annual-salary       80000    ; Gross annual salary (RAL - Retribuzione Annua Lorda)
   :calculation-period  "1° ottobre 2024 - 1° settembre 2025"  ; Reference period for calculations
   :previous-salary     60000    ; Previous salary used as baseline for calculations
   
   ;; Vector of maps - each map represents a payment step
   ;; Vectors maintain insertion order and provide indexed access
   :payment-steps       [{:step 1 :description "Firma del contratto" :amount 12000}
                         {:step 2 :description "Fine del terzo mese di lavoro" :amount 12000}
                         {:step 3 :description "Fine del sesto mese di lavoro" :amount 12000}]
   
   ;; Nested map for contract conditions - boolean flags for various terms
   ;; Using descriptive keywords to make the data self-documenting
   :contract-conditions {:waive-naspi-notice     true   ; Waiver of unemployment benefits and notice
                        :no-probation-period    true   ; Skip probationary period
                        :legal-notice-period    true}  ; Standard legal notice period applies
   
   ;; Vector of strings - documentation of past grievances
   ;; Vectors are preferred over lists for random access patterns
   :grievance-clauses   ["Contratti precedenti interrotti ingiustamente dopo 2 mesi"
                        "Mancata corresponsione di NASpI e indennità di preavviso"
                        "Danni economici e professionali documentati"]})

;; Function definition using 'defn' - creates a named function
;; Takes a terms map and renders it into a formatted string representation
;; Using destructuring in the let binding for clean code
(defn render-contract-terms [terms-map]
  ;; 'let' creates local bindings - destructuring the map for easier access
  ;; The :keys syntax extracts values from map using the same names as keywords
  (let [{:keys [net-bonus annual-salary calculation-period previous-salary 
                payment-steps contract-conditions grievance-clauses]} terms-map
        
        ;; Thread-first macro (->) chains operations left-to-right
        ;; Each result becomes the first argument of the next function
        ;; Building a vector of strings that will be joined later
        contract-lines (-> []
                          ;; 'conj' adds elements to the end of a vector (conjoin)
                          ;; Returns a new vector - immutability is preserved
                          (conj "PROPOSTA CONTRATTUALE – SENIOR SOFTWARE ENGINEER\n")
                          
                          ;; 'format' works like printf - %,d formats integers with thousand separators
                          (conj (format "Bonus di ingresso: € %,d netti (pagato in 3 rate da € 12.000) - Calcolo: 3 × € 12.000 = € 36.000." net-bonus))
                          (conj (format "Retribuzione annua lorda (RAL): € %,d." annual-salary))
                          (conj (format "Calcolo basato su periodo %s (da RAL € %,d + regalo Natale 2024)." calculation-period previous-salary))
                          (conj "\nRate bonus di ingresso:")
                          
                          ;; 'into' is like reduce - adds multiple elements to a collection
                          ;; 'map' transforms each element using the provided function
                          ;; Anonymous function syntax: #() where %1, %2 are positional args
                          ;; Destructuring within the map function for clean access
                          (into (map (fn [{:keys [step description amount]}]
                                      (format "  - Step %d: %s → € %,d" step description amount)) 
                                    payment-steps))
                          
                          (conj "\nCondizioni contrattuali richieste:")
                          
                          ;; Conditional formatting using 'if' expressions
                          ;; Keywords can be used as functions to look up values in maps
                          (conj (format "  - Nessun periodo di prova: %s" 
                                       (if (:no-probation-period contract-conditions) "sì" "no")))
                          (conj (format "  - Preavviso secondo legge (min. 2 mesi): %s" 
                                       (if (:legal-notice-period contract-conditions) "sì" "no")))
                          (conj (format "  - Rinuncia a NASpI e preavviso arretrati: %s (tramite Avvocati + rinuncia a sputtanamento planetario)" 
                                       (if (:waive-naspi-notice contract-conditions) "sì" "no")))
                          
                          (conj "\nMotivazioni alla base delle richieste:")
                          
                          ;; Reader macro #() creates anonymous function
                          ;; % is shorthand for the single argument
                          (into (map #(format "  - %s" %) grievance-clauses)))]
    
    ;; 'str/join' concatenates collection elements with specified delimiter
    ;; Returns the final formatted string representation
    (str/join "\n" contract-lines)))

;; Public API function - main entry point for contract generation
;; Zero-arity function that uses our predefined terms
;; Follows the principle of least surprise - simple interface, complex implementation
(defn generate-contract-proposal []
  (render-contract-terms contract-terms))

;; Side-effect: print the generated contract to stdout
;; In production code, you might want to return the string instead of printing
;; 'println' automatically adds newline, unlike 'print'
(println (generate-contract-proposal))
