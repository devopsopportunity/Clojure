# 📝 Clojure Contractual Proposal Generator

A simple but powerful 🇮🇹 **Italian Employment Contract Generator**, written in **Clojure** 🛠️.

This tool was created to **structure and print a clear employment contract proposal** with:
- 💶 **Entry bonus split into steps**  
- 💼 **Annual salary (RAL)**
- 📃 **Legal clauses and conditions**
- ⚖️ **Grievance documentation from previous bad contracts**

> ✅ Made with ❤️ and frustration by **Edoardo Sabatini**, August 4th, 2025  
> 💡 Built using **functional programming** principles in Clojure.

---

## 🧠 What does it do?

This script generates a **human-readable contract proposal**, including:

- ✨ A net bonus (**€36,000**) split into 3 parts of €12,000 each
- 💰 Annual salary of **€80,000** gross (RAL) 
- 🚫 No probation period, legal 2-month notice
- 📋 Calculation period: October 1st, 2024 → September 1st, 2025
- 🎁 Includes Christmas bonus 2024 considerations
- ⚖️ Legal waiver conditions (with lawyers involved!)

The output is printed to the terminal (you can also redirect it to a `.txt` file if needed).

---

## 🚀 How to run it (for total beginners)

### 📦 Step 1: Install Clojure (1-time only)

**On Ubuntu/Debian Linux:**
```bash
sudo apt update
sudo apt install clojure
```

**On macOS (with Homebrew):**
```bash
brew install clojure/tools/clojure
```

**On Windows:**
1. Download and install [Java JDK 8+](https://adoptium.net/)
2. Download [Clojure CLI tools](https://clojure.org/guides/install_clojure)
3. Follow the installation guide

### 📁 Step 2: Download the code

**Option A: Clone with Git** 🐙
```bash
git clone https://github.com/devopsopportunity/Clojure.git
cd Clojure
```

**Option B: Download manually** 📥
1. Download the `.clj` file from this repository
2. Save it as `contractual_proposal.clj` on your computer
3. Open terminal/command prompt in that folder

### ⚡ Step 3: Run the script

**Simple way (just see the output):**
```bash
clojure contractual_proposal.clj
```

**Save to file:**
```bash
clojure contractual_proposal.clj > my_contract_proposal.txt
```

**For Windows users:**
```cmd
clojure contractual_proposal.clj
```

---

## 📄 Sample Output

```
PROPOSTA CONTRATTUALE – SENIOR SOFTWARE ENGINEER

Bonus di ingresso: € 36,000 netti (pagato in 3 rate da € 12.000) - Calcolo: 3 × € 12.000 = € 36.000.
Retribuzione annua lorda (RAL): € 80,000.
Calcolo basato su periodo 1° ottobre 2024 - 1° settembre 2025 (da RAL € 60,000 + regalo Natale 2024).

Rate bonus di ingresso:
  - Step 1: Firma del contratto → € 12,000
  - Step 2: Fine del terzo mese di lavoro → € 12,000  
  - Step 3: Fine del sesto mese di lavoro → € 12,000

Condizioni contrattuali richieste:
  - Nessun periodo di prova: sì
  - Preavviso secondo legge (min. 2 mesi): sì
  - Rinuncia a NASpI e preavviso arretrati: sì (tramite Avvocati + rinuncia a sputtanamento planetario)

Motivazioni alla base delle richieste:
  - Contratti precedenti interrotti ingiustamente dopo 2 mesi
  - Mancata corresponsione di NASpI e indennità di preavviso
  - Danni economici e professionali documentati
```

---

## 🛠️ Customization

Want to modify the contract terms? Edit these values in the code:

```clojure
(def contract-terms
  {:net-bonus           36000     ; Change bonus amount
   :annual-salary       80000     ; Change salary
   :previous-salary     60000     ; Change baseline salary
   :payment-steps       [...]     ; Modify payment schedule
   :contract-conditions {...}     ; Adjust conditions
   :grievance-clauses   [...]})   ; Add/remove grievances
```

---

## ❓ Troubleshooting

**"Command not found: clojure"**  
→ Clojure is not installed. Go back to Step 1.

**"java: command not found"**  
→ Install Java JDK 8 or higher first.

**File not found error**  
→ Make sure you're in the correct directory with the `.clj` file.

**Permission denied (Linux/Mac)**  
→ Try: `chmod +x contractual_proposal.clj`

---

## 🤓 For Developers

This project demonstrates:
- **Functional programming** patterns in Clojure
- **Immutable data structures** (maps, vectors)
- **Thread-first macro** (`->`) for data transformation
- **Destructuring** for clean code
- **Namespace organization** and documentation

The code is heavily commented with explanations of each Clojure construct for educational purposes.

---

## 📜 License

MIT License - Feel free to use, modify, and distribute! 🆓

---

## 🤝 Contributing

Found a bug? Want to add features? Pull requests welcome! 

**Ideas for improvements:**
- 📊 Export to PDF format
- 🌐 Web interface  
- 🔧 Command-line arguments for easy customization
- 🌍 Multi-language support

---

**Happy contracting! 🎉📋**
