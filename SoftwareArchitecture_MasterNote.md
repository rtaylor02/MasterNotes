# Software Architecture
## Things that Affects Our SA
1. Stakeholder
2. Requirements:
   - Functional requirements (FR): ***'What shall X do?'*** ==> ***'When..., then the system shall...'***
   - Quality/Non-Functional Requirements (QR/NFR): ***'How shall X be?'*** ==> ***'The system/component/architecture shall be...'***
   - System constraints

### Stakeholders
= anyone that has interest in the system: PMs, customers, devs, QA, IT ops, investors, 3<sup>rd</sup> party service providers, etc.

### NFR


### QR
Some QRs:
- Performance: throughput and latency
- Efficiency: work done for resources used
- Scalability: potential to increase performance
  - Vertical Scaling: **scaling up** = capacity increase, more powerful resource, etc ==> inherent quality
  - Horizonal Scaling: **scaling out** = adding more resources ==> number
- Elastic scalability: only scale out when needed and scale in when not needed ==> <ins>Goldilock principle</ins>

### Constraints
= ***externally imposed limitation*** on system during development or modification to meet its FR & QR.

Types:
- technical constraints
- budget constraints
- legal constraints



# Resources
1. [CPSA-F course - Michael Pogrebinsky](https://topdeveloperacademy.com/certified-professional-for-software-architecture-foundational-level-training-cpsa-f)
2. [Designing Complex Software Systems - Craig Errey](https://learning.oreilly.com/live-events/designing-complex-software-systems/0642572011661/0642572011660/)
3. [Designing Hexagonal Architecture with Java - Davi Vieira](https://learning.oreilly.com/library/view/designing-hexagonal-architecture/9781801816489/)
