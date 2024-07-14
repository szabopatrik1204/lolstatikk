        document.addEventListener('DOMContentLoaded', function () {
            console.log('DOM fully loaded and parsed');
            // Itt is lehetőség van egy alapértelmezett lekérdezésre
            fetchChampions('name', 'asc');
        });

        function fetchChampions(sortField, sortDirection) {
            const requestBody = {
                sortField: sortField,
                sortDirection: sortDirection
            };

            fetch('/champions/sort', {
                method: 'POST', // POST metódus biztosítása
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requestBody)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                updateTable(data);
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
        }

        function updateTable(data) {
            const tbody = document.querySelector('tbody');
            tbody.innerHTML = '';
            data.forEach(champion => {
                const tags = champion.tags ? champion.tags.join(', ') : '';
                const row = `<tr>
                    <td>${champion.name}</td>
                    <td>${champion.title}</td>
                    <td>${champion.parType}</td>
                    <td>${tags}</td>
                    <td>${champion.hp}</td>
                    <td>${champion.hpPerLevel}</td>
                    <td>${champion.mp}</td>
                    <td>${champion.mpPerLevel}</td>
                    <td>${champion.moveSpeed}</td>
                    <td>${champion.armor}</td>
                    <td>${champion.armorPerLevel}</td>
                    <td>${champion.magicResist}</td>
                    <td>${champion.magicResistPerLevel}</td>
                    <td>${champion.attackRange}</td>
                    <td>${champion.hpRegen}</td>
                    <td>${champion.hpRegenPerLevel}</td>
                    <td>${champion.mpRegen}</td>
                    <td>${champion.mpRegenPerLevel}</td>
                    <td>${champion.crit}</td>
                    <td>${champion.critPerLevel}</td>
                    <td>${champion.attackDamage}</td>
                    <td>${champion.attackDamagePerLevel}</td>
                    <td>${champion.attackSpeedPerLevel}</td>
                    <td>${champion.attackSpeed}</td>
                </tr>`;
                tbody.innerHTML += row;
            });
        }