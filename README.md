# Cómo usar la API

**URL Raíz:** `https://analisiadn-9.onrender.com`

### Endpoints

- **Obtener todos los registros cargados:**  
  `GET /api/v1/humano/mutant`

- **Obtener cantidad de mutantes y humanos:**  
  `GET /api/v1/humano/mutant/stats`

- **Enviar ADN para validar si es mutante:**  
  `POST /api/v1/humano/mutant`

### Ejemplos de ADN para Mutantes y Humanos

#### Mutantes:

1.
   `{ "dna": ["AAAA", "CCCC", "TCAG", "GGTC"] }`

2.
   `{ "dna": ["TGAC", "AGCC", "TGAC", "GGTC"] }`

3.
   `{ "dna": ["TCGGTGATA", "TGATCCTTT", "TACGAGTGA", "AAATGTACT", "ACGAGTGCT", "AGACACTAG", "GAACTCCAA", "ACTACGACC", "TGAGTATCC"] }`

#### Humanos:

1.
   `{ "dna": ["AAAT", "AACC", "AAAC", "CGGG"] }`

2.
   `{ "dna": ["AAAA", "AAAA", "AAAA", "AAAA"] }`

3.
   `{ "dna": ["TGAC", "ATCC", "TAAG", "GGTC"] }`

  
