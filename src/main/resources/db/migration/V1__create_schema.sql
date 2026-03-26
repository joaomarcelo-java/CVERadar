-- ============================================================
--  CVERadar — V1__create_schema.sql
--  Flyway migration inicial
-- ============================================================

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- ============================================================
-- SOFTWARES
-- ============================================================
CREATE TABLE softwares (
                           id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                           nome     VARCHAR(255) NOT NULL,
                           cpe_nome VARCHAR(500)
);

-- ============================================================
-- USUARIOS
-- ============================================================
CREATE TABLE usuarios (
                          id    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          email VARCHAR(255) UNIQUE NOT NULL
);

-- ============================================================
-- RELACOES (tabela de junção Usuario <-> Software)
-- ============================================================
CREATE TABLE relacoes (
                          usuario_id  UUID NOT NULL REFERENCES usuarios(id)  ON DELETE CASCADE,
                          software_id UUID NOT NULL REFERENCES softwares(id) ON DELETE CASCADE,
                          PRIMARY KEY (usuario_id, software_id)
);

-- ============================================================
-- CVES
-- ============================================================
CREATE TABLE cves (
                      id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                      cve_id               VARCHAR(30)    NOT NULL UNIQUE,
                      severidade           VARCHAR(10),
                      descricao            TEXT,
                      exploitability_score NUMERIC(4,1),
                      impact_score         NUMERIC(4,1),
                      patch_disponivel     BOOLEAN        NOT NULL DEFAULT FALSE,
                      software_id          UUID           NOT NULL REFERENCES softwares(id) ON DELETE CASCADE
);

-- ============================================================
-- TOKENS_EDICAO
-- ============================================================
CREATE TABLE tokens_edicao (
                               id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                               token      UUID         NOT NULL UNIQUE DEFAULT gen_random_uuid(),
                               expira_em  TIMESTAMP    NOT NULL,
                               ativo      BOOLEAN      NOT NULL DEFAULT TRUE,
                               usuario_id UUID         NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE
);

-- ============================================================
-- NOTIFICACOES
-- ============================================================
CREATE TABLE notificacoes (
                              id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                              enviado_em  TIMESTAMP NOT NULL DEFAULT NOW(),
                              sucesso     BOOLEAN   NOT NULL DEFAULT TRUE,
                              cve_id      UUID      NOT NULL REFERENCES cves(id)     ON DELETE CASCADE,
                              usuario_id  UUID      NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
                              CONSTRAINT uq_notificacao UNIQUE (cve_id, usuario_id)
);

-- ============================================================
-- ÍNDICES
-- ============================================================
CREATE INDEX idx_relacoes_usuario    ON relacoes(usuario_id);
CREATE INDEX idx_relacoes_software   ON relacoes(software_id);
CREATE INDEX idx_cves_software       ON cves(software_id);
CREATE INDEX idx_cves_severidade     ON cves(severidade);
CREATE INDEX idx_tokens_usuario      ON tokens_edicao(usuario_id);
CREATE INDEX idx_tokens_token        ON tokens_edicao(token);
CREATE INDEX idx_notificacoes_usuario ON notificacoes(usuario_id);

-- ============================================================
-- DADOS INICIAIS — Catálogo de softwares
-- ============================================================
INSERT INTO softwares (nome, cpe_nome) VALUES
                                           ('Ubuntu',         'cpe:2.3:o:canonical:ubuntu_linux'),
                                           ('Windows 11',     'cpe:2.3:o:microsoft:windows_11'),
                                           ('Windows Server', 'cpe:2.3:o:microsoft:windows_server'),
                                           ('Debian',         'cpe:2.3:o:debian:debian_linux'),
                                           ('Chrome',         'cpe:2.3:a:google:chrome'),
                                           ('Firefox',        'cpe:2.3:a:mozilla:firefox'),
                                           ('Edge',           'cpe:2.3:a:microsoft:edge'),
                                           ('MySQL',          'cpe:2.3:a:oracle:mysql'),
                                           ('PostgreSQL',     'cpe:2.3:a:postgresql:postgresql'),
                                           ('MongoDB',        'cpe:2.3:a:mongodb:mongodb'),
                                           ('Redis',          'cpe:2.3:a:redis:redis'),
                                           ('Spring Boot',    'cpe:2.3:a:vmware:spring_boot'),
                                           ('Node.js',        'cpe:2.3:a:nodejs:node.js'),
                                           ('Django',         'cpe:2.3:a:djangoproject:django'),
                                           ('Java',           'cpe:2.3:a:oracle:jdk'),
                                           ('PHP',            'cpe:2.3:a:php:php'),
                                           ('Python',         'cpe:2.3:a:python:python'),
                                           ('Apache HTTP',    'cpe:2.3:a:apache:http_server'),
                                           ('Nginx',          'cpe:2.3:a:f5:nginx'),
                                           ('Tomcat',         'cpe:2.3:a:apache:tomcat'),
                                           ('OpenSSL',        'cpe:2.3:a:openssl:openssl'),
                                           ('Log4j',          'cpe:2.3:a:apache:log4j'),
                                           ('Docker',         'cpe:2.3:a:docker:docker'),
                                           ('Kubernetes',     'cpe:2.3:a:kubernetes:kubernetes');